import java.awt.Color;

public class Amenaza {
    static Amenaza[] amenazas;
    private int fila;
    private int columna;
    public int cantidadA;
    int coordC1;
    int coordF1;
    int coordC2;
    int coordF2;
    int elim = 0;
    public int vida;


    public Amenaza(Amenaza[] amen){
        amenazas = amen;
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
        coordC1 = columna;
        coordF1 = fila;
        coordC2 = columna+1;
        coordF2 = fila+1;
        vida = 10;
    }

    public Amenaza(){

    }

    public void pintarAmen(int i){
        boolean libre = false;
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
        while(libre != true){
            if(Matriz.bMatriz[fila][columna].getBackground() != (Matriz.verde) || Matriz.bMatriz[fila][columna+1].getBackground() != (Matriz.verde) || Matriz.bMatriz[fila+1][columna+1].getBackground() != (Matriz.verde) || Matriz.bMatriz[fila+1][columna].getBackground() != (Matriz.verde)){
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
            }
            else{
                System.out.println("fila" + fila + "columna" + columna);
                Matriz.bMatriz[fila][columna].setBackground(Color.yellow);
                Matriz.bMatriz[fila][columna+1].setBackground(Color.yellow);
                Matriz.bMatriz[fila+1][columna].setBackground(Color.yellow);
                Matriz.bMatriz[fila+1][columna+1].setBackground(Color.yellow);
                cantidadA++;
                libre = true;
                guardar(i);
            }
        }  
    }

    public void guardar(int i){
        amenazas[i].coordC1 = columna;
        amenazas[i].coordF1 = fila;
        amenazas[i].coordC2 = columna+1;
        amenazas[i].coordF2 = fila+1;
        System.out.println("hormiga numero" + i + " coordenadas " + amenazas[i].coordC1 + " "+ amenazas[i].coordF1);
    }

    public void ataca(int F, int C){
        int i = 0;
        while(i != 10){
            System.out.println("coordF" + amenazas[i].coordF1 + "coordC" + amenazas[i].coordC1 + "coordf1" + amenazas[i].coordF2 + "coordc2" + amenazas[i].coordC2);
            System.out.println("vienen " + F + " " + C);
            if(amenazas[i].coordC1 == C && amenazas[i].coordF1 == F)
                amenazas[i].vida--;
            else if(amenazas[i].coordC2 == C && amenazas[i].coordF2 == F)
                amenazas[i].vida--;
            else if(amenazas[i].coordC1 == C && amenazas[i].coordF2 == F)
                amenazas[i].vida--;
            else if(amenazas[i].coordC2 == C && amenazas[i].coordF1 == F)
                amenazas[i].vida--;
            System.out.println("vidas " + i + " " + amenazas[i].vida);
            i++;
        }
        destruir();
    }
    public void respawn(){
        System.out.println("nuevo" + cantidadA);
        pintarAmen(elim);
        amenazas[elim].vida = 10;
        System.out.println(amenazas[elim].vida);
        cantidadA++;
        System.out.println("nuevas " + "coordF" + amenazas[elim].coordF1 + "coordC" + amenazas[elim].coordC1 + "coordf1" + amenazas[elim].coordF2 + "coordc2" + amenazas[elim].coordC2);
        System.out.println(cantidadA);

    }

    public void destruir(){
        int i = 0;
        while(i != 10){
            if(amenazas[i].vida <= 0){
                cantidadA--;
                System.out.println("entro");
                Matriz.bMatriz[amenazas[i].coordF1][amenazas[i].coordC1].setBackground(Matriz.verde);
                Matriz.bMatriz[amenazas[i].coordF2][amenazas[i].coordC2].setBackground(Matriz.verde);
                Matriz.bMatriz[amenazas[i].coordF1][amenazas[i].coordC2].setBackground(Matriz.verde);
                Matriz.bMatriz[amenazas[i].coordF2][amenazas[i].coordC1].setBackground(Matriz.verde);
                elim = i;
                respawn();
            }
            i++;
        }
    }


}



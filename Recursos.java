import java.awt.Color;

public class Recursos{
    private int fila;
    private int columna;
    public int cantidadA;
    static Recursos[] rec;
    int coordC1;
    int coordF1;
    int coordC2;
    int coordF2;
    int elim = 0;
    public int vida;

    public Recursos(Recursos[] recursos){
        rec = recursos;
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
        coordC1 = columna;
        coordF1 = fila;
        coordC2 = columna+1;
        coordF2 = fila+1;
        vida = 10;
        pintarRec();
    }

    public Recursos(){

    }

    private void pintarRec(){
        boolean libre = false;
        while(libre != true){
            if(Matriz.bMatriz[fila][columna].getBackground() != (Matriz.verde) && Matriz.bMatriz[fila][columna+1].getBackground() != (Matriz.verde) && Matriz.bMatriz[fila+1][columna+1].getBackground() != (Matriz.verde) && Matriz.bMatriz[fila+1][columna].getBackground() != (Matriz.verde)){
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
            }
            else{
                System.out.println("fila" + fila + "columna" + columna);
                Matriz.bMatriz[fila][columna].setBackground(Color.MAGENTA);
                Matriz.bMatriz[fila][columna+1].setBackground(Color.MAGENTA);
                Matriz.bMatriz[fila+1][columna].setBackground(Color.MAGENTA);
                Matriz.bMatriz[fila+1][columna+1].setBackground(Color.MAGENTA);
                cantidadA++;
                libre = true;
            }
        } 
    }
    
    public void guardar(){
        rec[cantidadA].coordC1 = columna;
        rec[cantidadA].coordF1 = fila;
        rec[cantidadA].coordC2 = columna+1;
        rec[cantidadA].coordF2 = fila+1;
    }

    public void recolecta(Recursos[] reap, int F, int C, AgenteBase[] hormiga){
        int i = 0;
        while(i != 10){
            System.out.println("coordF" + reap[i].coordF1 + "coordC" + reap[i].coordC1 + "coordf1" + reap[i].coordF2 + "coordc2" + reap[i].coordC2);
            System.out.println("vienen " + F + " " + C);
            if(reap[i].coordC1 == C && reap[i].coordF1 == F)
                reap[i].vida--;
            else if(reap[i].coordC2 == C && reap[i].coordF2 == F)
                reap[i].vida--;
            else if(reap[i].coordC1 == C && reap[i].coordF2 == F)
                reap[i].vida--;
            else if(reap[i].coordC2 == C && reap[i].coordF1 == F)
                reap[i].vida--;
            System.out.println("vidas " + i + " " + reap[i].vida);
            i++;
        }
        hormiga[Matriz.nHormiga].llevaR = true;
        destruir();
    }
    public void respawn(){
        System.out.println("nuevo" + cantidadA);
        pintarRec();
        rec[elim].vida = 10;
        System.out.println(rec[elim].vida);
        rec[elim].coordC1 = columna;
        rec[elim].coordF1 = fila;
        rec[elim].coordC2 = columna+1;
        rec[elim].coordF2 = fila+1;
        cantidadA++;
        System.out.println("nuevas " + "coordF" + rec[elim].coordF1 + "coordC" + rec[elim].coordC1 + "coordf1" + rec[elim].coordF2 + "coordc2" + rec[elim].coordC2);
        System.out.println(cantidadA);

    }

    public void destruir(){
        int i = 0;
        while(i != 10){
            if(rec[i].vida <= 0){
                cantidadA--;
                System.out.println("entro");
                Matriz.bMatriz[rec[i].coordF1][rec[i].coordC1].setBackground(Matriz.verde);
                Matriz.bMatriz[rec[i].coordF2][rec[i].coordC2].setBackground(Matriz.verde);
                Matriz.bMatriz[rec[i].coordF1][rec[i].coordC2].setBackground(Matriz.verde);
                Matriz.bMatriz[rec[i].coordF2][rec[i].coordC1].setBackground(Matriz.verde);
                elim = i;
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
                respawn();
            }
            i++;
        }
    }
}
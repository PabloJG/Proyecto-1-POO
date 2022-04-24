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
    }

    public Recursos(){

    }

    public void pintarRec(int i){
        boolean libre = false;
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
        while(libre != true){
            if(Matriz.bMatriz[fila][columna].getBackground() != (Matriz.verde) || Matriz.bMatriz[fila][columna+1].getBackground() != (Matriz.verde) || Matriz.bMatriz[fila+1][columna+1].getBackground() != (Matriz.verde) || Matriz.bMatriz[fila+1][columna].getBackground() != (Matriz.verde)){
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
            }
            else{
                System.out.println("Rfila" + fila + "columna" + columna);
                Matriz.bMatriz[fila][columna].setBackground(Color.MAGENTA);
                Matriz.bMatriz[fila][columna+1].setBackground(Color.MAGENTA);
                Matriz.bMatriz[fila+1][columna].setBackground(Color.MAGENTA);
                Matriz.bMatriz[fila+1][columna+1].setBackground(Color.MAGENTA);
                cantidadA++;
                libre = true;
                guardar(i);
            }
        } 
    }
    
    public void guardar(int i){
        rec[i].coordC1 = columna;
        rec[i].coordF1 = fila;
        rec[i].coordC2 = columna+1;
        rec[i].coordF2 = fila+1;
    }

    public void recolecta(int F, int C, AgenteBase[] hormiga){
        int i = 0;
        while(i != 10){
            System.out.println("RcoordF" + rec[i].coordF1 + "coordC" + rec[i].coordC1 + "coordf1" + rec[i].coordF2 + "coordc2" + rec[i].coordC2);
            System.out.println("Rvienen " + F + " " + C);
            if(rec[i].coordC1 == C && rec[i].coordF1 == F)
                rec[i].vida--;
            else if(rec[i].coordC2 == C && rec[i].coordF2 == F)
                rec[i].vida--;
            else if(rec[i].coordC1 == C && rec[i].coordF2 == F)
                rec[i].vida--;
            else if(rec[i].coordC2 == C && rec[i].coordF1 == F)
                rec[i].vida--;
            System.out.println("vidasR " + i + " " + rec[i].vida);
            i++;
        }
        hormiga[Matriz.nHormiga].llevaR = true;
        destruir();
    }
    public void respawn(){
        System.out.println("Rnuevo" + cantidadA);
        pintarRec(elim);
        rec[elim].vida = 10;
        System.out.println(rec[elim].vida);
        cantidadA++;
        //System.out.println("nuevas " + "coordF" + rec[elim].coordF1 + "coordC" + rec[elim].coordC1 + "coordf1" + rec[elim].coordF2 + "coordc2" + rec[elim].coordC2);
        //System.out.println(cantidadA);

    }

    public void destruir(){
        int i = 0;
        while(i != 10){
            if(rec[i].vida <= 0){
                cantidadA--;
                System.out.println("Rentro");
                Matriz.bMatriz[rec[i].coordF1][rec[i].coordC1].setBackground(Matriz.verde);
                Matriz.bMatriz[rec[i].coordF2][rec[i].coordC2].setBackground(Matriz.verde);
                Matriz.bMatriz[rec[i].coordF1][rec[i].coordC2].setBackground(Matriz.verde);
                Matriz.bMatriz[rec[i].coordF2][rec[i].coordC1].setBackground(Matriz.verde);
                elim = i;
                respawn();
            }
            i++;
        }
    }
}
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;

public class Amenaza {
    private int fila;
    private int columna;
    public int cantidadA;
    static Amenaza[] amenazas;
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
        pintarAmen();
    }

    public Amenaza(){

    }

    private void pintarAmen(){
        boolean libre = false;
        while(libre != true){
            if(Matriz.bMatriz[fila][columna].getBackground() != (Matriz.verde) && Matriz.bMatriz[fila][columna+1].getBackground() != (Matriz.verde) && Matriz.bMatriz[fila+1][columna+1].getBackground() != (Matriz.verde) && Matriz.bMatriz[fila+1][columna].getBackground() != (Matriz.verde)){
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
            }
        }  
    }

    public void guardar(){
        amenazas[cantidadA].coordC1 = columna;
        amenazas[cantidadA].coordF1 = fila;
        amenazas[cantidadA].coordC2 = columna+1;
        amenazas[cantidadA].coordF2 = fila+1;
    }

    public void ataca(Amenaza[] reap, int F, int C){
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
        destruir();
    }
    public void respawn(){
        System.out.println("nuevo" + cantidadA);
        pintarAmen();
        amenazas[elim].vida = 10;
        System.out.println(amenazas[elim].vida);
        amenazas[elim].coordC1 = columna;
        amenazas[elim].coordF1 = fila;
        amenazas[elim].coordC2 = columna+1;
        amenazas[elim].coordF2 = fila+1;
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
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
                respawn();
            }
            i++;
        }
    }


}



import java.awt.Color;

public class Amenaza {
    private int fila;
    private int columna;
    public static int cantidadA = 0;
    public int vida;


    public Amenaza(){
        pintarAmen();
        vida = 10;
    }

    private void pintarAmen(){
        while(cantidadA < 15){
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
            if(Matriz.bMatriz[fila][columna].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila][columna+1].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila+1][columna+1].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila+1][columna].getBackground().equals(Matriz.verde)){
                Matriz.bMatriz[fila][columna].setBackground(Color.yellow);
                Matriz.bMatriz[fila][columna+1].setBackground(Color.yellow);
                Matriz.bMatriz[fila+1][columna].setBackground(Color.yellow);
                Matriz.bMatriz[fila+1][columna+1].setBackground(Color.yellow);
                cantidadA++;
            }
            else{
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
            }
        }
    }
}

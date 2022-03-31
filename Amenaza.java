import java.awt.Color;

public class Amenaza {
    private int fila;
    private int columna;
    public static int cantidadA = 0;
    private Color color = new java.awt.Color(255, 172, 28);

    public Amenaza(){
        pintarAmen();
    }

    private void pintarAmen(){
        while(cantidadA < 5){
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
            if(Matriz.bMatriz[fila][columna].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila][columna+1].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila+1][columna+1].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila+1][columna].getBackground().equals(Matriz.verde)){
                Matriz.bMatriz[fila][columna].setBackground(color);
                Matriz.bMatriz[fila][columna+1].setBackground(color);
                Matriz.bMatriz[fila+1][columna].setBackground(color);
                Matriz.bMatriz[fila+1][columna+1].setBackground(color);
                cantidadA++;
            }
            else{
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
            }
        }
    }
}

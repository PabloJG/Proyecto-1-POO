import java.awt.Color;

public class Obstaculos {
    private int fila;
    private int columna;
    private int cantidad = 0;

    public Obstaculos(){
        pintarObs();
    }

    private void pintarObs(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(47-2)) + 2;
            columna = (int) (Math.random()*(47-2)) + 2;
            Matriz.bMatriz[fila][columna].setBackground(Color.MAGENTA);
            Matriz.bMatriz[fila][columna+1].setBackground(Color.MAGENTA);
            Matriz.bMatriz[fila+1][columna].setBackground(Color.MAGENTA);
            Matriz.bMatriz[fila+1][columna+1].setBackground(Color.MAGENTA);
            cantidad++;
        }
    }
}

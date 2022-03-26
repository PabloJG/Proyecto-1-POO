import java.awt.Color;

public class Obstaculos {
    private int fila;
    private int columna;
    private int cantidad = 0;
    private Color color = new java.awt.Color(158, 158, 158);

    public Obstaculos(){
        pintarObs();
    }

    private void pintarObs(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(47-2)) + 2;
            columna = (int) (Math.random()*(47-2)) + 2;
            Matriz.bMatriz[fila][columna].setBackground(color);
            Matriz.bMatriz[fila][columna+1].setBackground(new java.awt.Color(216, 216, 216));
            Matriz.bMatriz[fila+1][columna].setBackground(new java.awt.Color(132, 132, 132));
            Matriz.bMatriz[fila+1][columna+1].setBackground(color);
            cantidad++;
        }
    }
}

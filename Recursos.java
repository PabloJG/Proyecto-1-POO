import java.awt.Color;

public class Recursos{
    private int fila;
    private int columna;
    private int cantidad = 0;

    public Recursos(){
        pintarRec();
    }

    private void pintarRec(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
            Matriz.bMatriz[fila][columna].setBackground(new java.awt.Color(101, 21, 146));
            Matriz.bMatriz[fila][columna+1].setBackground(new java.awt.Color(63, 83, 229));
            Matriz.bMatriz[fila+1][columna].setBackground(new java.awt.Color(130, 255, 71));
            Matriz.bMatriz[fila+1][columna+1].setBackground(new java.awt.Color(255, 90, 90));
            cantidad++;
        }
    }
    
}
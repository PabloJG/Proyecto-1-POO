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
            Matriz.bMatriz[fila][columna].setBackground(Color.PINK);
            Matriz.bMatriz[fila][columna+1].setBackground(Color.PINK);
            Matriz.bMatriz[fila+1][columna].setBackground(Color.PINK);
            Matriz.bMatriz[fila+1][columna+1].setBackground(Color.PINK);
            cantidad++;
        }
    }
    
}
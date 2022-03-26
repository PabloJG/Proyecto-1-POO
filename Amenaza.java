import java.awt.Color;

public class Amenaza {
    private int fila;
    private int columna;
    private int cantidad = 0;
    private Color color = new java.awt.Color(255, 172, 28);

    public Amenaza(){
        pintarAmen();
    }

    private void pintarAmen(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
            Matriz.bMatriz[fila][columna].setBackground(color);
            Matriz.bMatriz[fila][columna+1].setBackground(color);
            Matriz.bMatriz[fila+1][columna].setBackground(color);
            Matriz.bMatriz[fila+1][columna+1].setBackground(color);
            cantidad++;
        }
    }
}

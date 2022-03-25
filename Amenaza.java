import java.awt.Color;

public class Amenaza {
    private int fila;
    private int columna;
    private int cantidad = 0;
    Matriz amenaza;

    public Amenaza(Matriz matriz){
        amenaza = matriz;
        pintarAmen();
    }

    public void pintarAmen(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
            amenaza.bMatriz[fila][columna].setBackground(Color.ORANGE);
            amenaza.bMatriz[fila][columna+1].setBackground(Color.ORANGE);
            amenaza.bMatriz[fila+1][columna].setBackground(Color.ORANGE);
            amenaza.bMatriz[fila+1][columna+1].setBackground(Color.ORANGE);
            cantidad++;
        }
    }
}

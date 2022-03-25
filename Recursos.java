import java.awt.Color;

public class Recursos{
    private int fila;
    private int columna;
    private int cantidad = 0;
    Matriz recursos;

    public Recursos(Matriz matriz){
        recursos = matriz;
        pintarRec();
    }

    public void pintarRec(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
            recursos.bMatriz[fila][columna].setBackground(Color.PINK);
            recursos.bMatriz[fila][columna+1].setBackground(Color.PINK);
            recursos.bMatriz[fila+1][columna].setBackground(Color.PINK);
            recursos.bMatriz[fila+1][columna+1].setBackground(Color.PINK);
            cantidad++;
        }
    }
    
}
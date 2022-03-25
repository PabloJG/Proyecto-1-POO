import java.awt.Color;

public class Obstaculos {
    private int fila;
    private int columna;
    private int cantidad = 0;
    Matriz obstaculo;

    public Obstaculos(Matriz matriz){
        obstaculo = matriz;
        pintarObs();
    }

    public void pintarObs(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(47-2)) + 2;
            columna = (int) (Math.random()*(47-2)) + 2;
            obstaculo.bMatriz[fila][columna].setBackground(Color.MAGENTA);
            obstaculo.bMatriz[fila][columna+1].setBackground(Color.MAGENTA);
            obstaculo.bMatriz[fila+1][columna].setBackground(Color.MAGENTA);
            obstaculo.bMatriz[fila+1][columna+1].setBackground(Color.MAGENTA);
            cantidad++;
        }
    }
}

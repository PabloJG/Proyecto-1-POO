import java.awt.Color;
import java.util.Random;

public class Obstaculos {
    private Random random = new Random();
    private int fila;
    private int columna;
    private int cantidad = 0;
    Matriz obstaculo = new Matriz();

    public Obstaculos(){
        pintarObs();
    }

    public void pintarObs(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(47-2)) + 2;
            columna = (int) (Math.random()*(47-2)) + 2;
            System.out.println(fila + " " + columna);
            obstaculo.bMatriz[fila][columna].setBackground(Color.MAGENTA);
            obstaculo.bMatriz[fila][columna+1].setBackground(Color.MAGENTA);
            obstaculo.bMatriz[fila+1][columna].setBackground(Color.MAGENTA);
            obstaculo.bMatriz[fila+1][columna+1].setBackground(Color.MAGENTA);
            //obstaculo.setVisible(true);
            cantidad++;
        }
    }
}

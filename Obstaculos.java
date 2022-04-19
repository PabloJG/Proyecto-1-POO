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
            if(Matriz.bMatriz[fila][columna].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila][columna+1].getBackground().equals(Matriz.verde)){
                Matriz.bMatriz[fila][columna].setBackground(Color.gray);
                Matriz.bMatriz[fila][columna+1].setBackground(Color.gray);
                Matriz.bMatriz[fila+1][columna].setBackground(Color.gray);
                Matriz.bMatriz[fila+1][columna+1].setBackground(Color.gray);
                cantidad++;
            }
            else{
                fila = (int) (Math.random()*(47-2)) + 2;
                columna = (int) (Math.random()*(47-2)) + 2;
            }
        }
    }
}

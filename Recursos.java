import java.awt.Color;

public class Recursos{
    private int fila;
    private int columna;
    public static int cantidad = 0;
    public int vida;

    public Recursos(){
        pintarRec();
        vida = 10;
    }

    private void pintarRec(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
            if(Matriz.bMatriz[fila][columna].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila][columna+1].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila+1][columna+1].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila+1][columna].getBackground().equals(Matriz.verde)){
                Matriz.bMatriz[fila][columna].setBackground(Color.MAGENTA);
                Matriz.bMatriz[fila][columna+1].setBackground(Color.MAGENTA);
                Matriz.bMatriz[fila+1][columna].setBackground(Color.MAGENTA);
                Matriz.bMatriz[fila+1][columna+1].setBackground(Color.MAGENTA);
                cantidad++;
            }
            else{
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
            }
        }
    }
    
}
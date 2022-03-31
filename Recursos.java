public class Recursos{
    private int fila;
    private int columna;
    public static int cantidad = 0;

    public Recursos(){
        pintarRec();
    }

    private void pintarRec(){
        while(cantidad < 5){
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
            if(Matriz.bMatriz[fila][columna].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila][columna+1].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila+1][columna+1].getBackground().equals(Matriz.verde) && Matriz.bMatriz[fila+1][columna].getBackground().equals(Matriz.verde)){
                Matriz.bMatriz[fila][columna].setBackground(new java.awt.Color(101, 21, 146));
                Matriz.bMatriz[fila][columna+1].setBackground(new java.awt.Color(63, 83, 229));
                Matriz.bMatriz[fila+1][columna].setBackground(new java.awt.Color(130, 255, 71));
                Matriz.bMatriz[fila+1][columna+1].setBackground(new java.awt.Color(255, 90, 90));
                cantidad++;
            }
            else{
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
            }
        }
    }
    
}
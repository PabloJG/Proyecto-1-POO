import java.util.Random;
import java.awt.Color;

public class AgenteBase {
    private int fila;
    public Color color;
    private int columna;
    private String posicion;
    private Random rand = new Random();
    private String[] posiciones = {"ARRIBA","ABAJO","IZQUIERDA","DERECHA"};
    private int pos = rand.nextInt(posiciones.length);
    
    public AgenteBase(){
        posicion = posiciones[pos];
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
    }

    public void pintar(){
        System.out.println(fila + " " + columna);
        if(Matriz.bMatriz[fila][columna].getBackground().equals(Matriz.verde))
            Matriz.bMatriz[fila][columna].setBackground(color);
        else{
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
        }
    }

    public void mover(AgenteBase[] hormiga){
        Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(new java.awt.Color(0, 135, 6));
       // Base.pintarBase();
        System.out.println(hormiga[Matriz.i] + hormiga[Matriz.i].posicion);
        if(hormiga[Matriz.i].posicion.equals("ARRIBA")){
            Matriz.bMatriz[hormiga[Matriz.i].fila+1][hormiga[Matriz.i].columna].setBackground(color);
            fila++;
        }
        else if(hormiga[Matriz.i].posicion.equals("ABAJO")){
            Matriz.bMatriz[hormiga[Matriz.i].fila-1][hormiga[Matriz.i].columna].setBackground(color);
            fila--;
        }
        else if(hormiga[Matriz.i].posicion.equals("IZQUIERDA")){
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna-1].setBackground(color);
            columna--;
        }
        else if(hormiga[Matriz.i].posicion.equals("DERECHA")){
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna+1].setBackground(color);
            columna++;
        }  
        pos = rand.nextInt(posiciones.length);
        posicion = posiciones[pos];
    }

    public void buscarRecurso(){

    }

}

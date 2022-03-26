import java.util.Random;
import java.awt.Color;

public class AgenteBase {
    private int fila = Base.random.get(Base.fila);
    private int columna = Base.random.get(Base.columna);;
    private String posicion;
    private Random rand = new Random();
    private String[] posiciones = {"ARRIBA","ABAJO","IZQUIERDA","DERECHA"};
    private int pos = rand.nextInt(posiciones.length);
    
    public AgenteBase(){
        posicion = posiciones[pos];
        System.out.println(fila + " " + columna + " " + posicion);
    }

    public void mover(){
        Matriz.bMatriz[fila][columna].setBackground(Color.WHITE);
        Base.pintarBase();
        Matriz.bMatriz[fila][columna+1].setBackground(Color.BLACK);
        columna++;
    }

    public void buscarRecurso(){

    }

}

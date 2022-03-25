import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Base {
    List<Integer> random = Arrays.asList(0, 49);
    Matriz base;
    Random rand = new Random();
    private int fila;
    private int columna;

    public Base(Matriz matriz){
        base = matriz;
        fila = rand.nextInt(random.size());
        columna = rand.nextInt(random.size()); 
        base.bMatriz[random.get(fila)][random.get(columna)].setBackground(Color.GREEN);
    }
}

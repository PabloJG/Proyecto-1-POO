import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Base {
    public static List<Integer> random = Arrays.asList(0, 49);
    private static Matriz base;
    private Random rand = new Random();
    public static int fila;
    public static int columna;

    public Base(Matriz matriz){
        base = matriz;
        fila = rand.nextInt(random.size());
        columna = rand.nextInt(random.size()); 
        base.bMatriz[random.get(fila)][random.get(columna)].setBackground(Color.GREEN);
    }
}

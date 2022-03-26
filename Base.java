import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Base {
    public static List<Integer> random = Arrays.asList(0, 49);
    private Random rand = new Random();
    public static int fila;
    public static int columna;

    public Base(){
        fila = rand.nextInt(random.size());
        columna = rand.nextInt(random.size());
        pintarBase(); 
    }

    public static void pintarBase(){
        Matriz.bMatriz[random.get(fila)][random.get(columna)].setBackground(new java.awt.Color(144, 79, 22));
    }
}

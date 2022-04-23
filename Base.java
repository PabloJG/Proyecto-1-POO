import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Base {
    public static List<Integer> random = Arrays.asList(0, 49);
    private Random rand = new Random();
    public static int BFila;
    public static int BColumna;

    public Base(){
        BFila = rand.nextInt(random.size());
        BColumna = rand.nextInt(random.size());
        BFila = random.get(BFila);
        BColumna = random.get(BColumna);
        pintarBase(); 
    }

    public static void pintarBase(){
        Matriz.bMatriz[BFila][BColumna].setBackground(new java.awt.Color(144, 79, 22));
    }
}

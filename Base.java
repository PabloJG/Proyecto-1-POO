import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Base {
    List<Integer> random = Arrays.asList(0, 49);
    Matriz base = new Matriz();
    Random rand = new Random();
    private int fila;
    private int columna;

    public Base(){
        fila = rand.nextInt(random.size());
        columna = rand.nextInt(random.size()); 
        System.out.println(fila + " " + columna);
        System.out.println(random.get(fila)+ " " + random.get(columna));
        base.bMatriz[random.get(fila)][random.get(columna)].setBackground(Color.GREEN);
        //base.setVisible(true);
    }
}

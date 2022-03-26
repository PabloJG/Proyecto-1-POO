import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Matriz{
    private static JFrame ventana = new JFrame();
    private static JPanel boton = new JPanel();
    private static JButton siguiente = new JButton("Siguiente");
    public static JButton bMatriz[][] = new JButton[50][50];
    private static JPanel panel = new JPanel();

    public Matriz(){
        panel.setLayout(new GridLayout(50, 50));
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearMatriz();
    }

    private void crearMatriz(){
        for (int f = 0; f < 50; f++) {
            for (int c = 0; c < 50; c++) {
                bMatriz[f][c] = new JButton();
                bMatriz[f][c].setBounds(20, 10, 360, 360);
                bMatriz[f][c].setBackground(Color.WHITE);
                //bMatriz[f][c].setBorderPainted(false);
                ventana.setBounds(300, 20, 850, 710);
                panel.setBounds(300, 20, 850, 710);
                panel.add(bMatriz[f][c]);
                panel.setVisible(true);
            }
        }
        ventana.setVisible(true);
        boton.setLayout(new GridLayout(1, 1));
        boton.add(siguiente);
        siguiente.setBackground(Color.WHITE);
        ventana.add(boton, BorderLayout.EAST);
        
    }
    private void siguiente(AgenteBase mov){

    }
}
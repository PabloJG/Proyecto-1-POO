import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Color;

public class Matriz implements ActionListener{
    public static int i=0;
    public static Color verde = new java.awt.Color(0, 135, 6);
    private static JFrame ventana = new JFrame();
    private static JPanel boton = new JPanel();
    private AgenteBase[] move;
    private static JButton siguiente = new JButton("Siguiente");
    public static JButton bMatriz[][] = new JButton[50][50];
    private static JPanel panel = new JPanel();

    public Matriz(AgenteBase[] mover){
        move = mover;
        siguiente.addActionListener(this);
        panel.setLayout(new GridLayout(50, 50));
        panel.setBackground(new java.awt.Color(0, 151, 7));
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearMatriz();
    }

    private void crearMatriz(){
        for (int f = 0; f < 50; f++) {
            for (int c = 0; c < 50; c++) {
                bMatriz[f][c] = new JButton();
                bMatriz[f][c].setBounds(20, 10, 360, 360);
                bMatriz[f][c].setBackground(verde);
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
        siguiente.setBackground(new java.awt.Color(201, 255, 237));
        ventana.add(boton, BorderLayout.EAST);
        
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == siguiente) {
            i = 0;
            while(i<20){
                move[i].mover(move);
                i++;
            }
        }
      }
}
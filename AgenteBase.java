import java.util.Random;
import java.awt.Color;

public class AgenteBase {
    static int i = 0;
    private int fila;
    String tipo;
    private int columna = Base.random.get(Base.columna);
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
        if(i < 10)
            Matriz.bMatriz[fila][columna].setBackground(Color.RED);
        else
             Matriz.bMatriz[fila][columna].setBackground(Color.BLACK);
        i++;
    }

    public void mover(AgenteBase[] hormiga){
        Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(new java.awt.Color(0, 135, 6));
        Base.pintarBase();
        System.out.println(hormiga[Matriz.i] + hormiga[Matriz.i].posicion);
        if(hormiga[Matriz.i].posicion.equals("ARRIBA")){
            if(hormiga[Matriz.i].tipo.equals("defensor"))
                Matriz.bMatriz[hormiga[Matriz.i].fila+1][hormiga[Matriz.i].columna].setBackground(Color.RED);
            else
                Matriz.bMatriz[hormiga[Matriz.i].fila+1][hormiga[Matriz.i].columna].setBackground(Color.BLACK);
            fila++;
        }
        else if(hormiga[Matriz.i].posicion.equals("ABAJO")){
            if(hormiga[Matriz.i].tipo.equals("defensor"))
                Matriz.bMatriz[hormiga[Matriz.i].fila-1][hormiga[Matriz.i].columna].setBackground(Color.RED);
            else
                Matriz.bMatriz[hormiga[Matriz.i].fila-1][hormiga[Matriz.i].columna].setBackground(Color.BLACK);
            fila--;
        }
        else if(hormiga[Matriz.i].posicion.equals("IZQUIERDA")){
            if(hormiga[Matriz.i].tipo.equals("defensor"))
                Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna-1].setBackground(Color.RED);
            else
                Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna-1].setBackground(Color.BLACK);
            columna--;
        }
        else if(hormiga[Matriz.i].posicion.equals("DERECHA")){
            if(hormiga[Matriz.i].tipo.equals("defensor"))
                Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna+1].setBackground(Color.RED);
            else
                Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna+1].setBackground(Color.BLACK);
            columna++;
        }  
        pos = rand.nextInt(posiciones.length);
        posicion = posiciones[pos];
    }

    public void buscarRecurso(){

    }

}

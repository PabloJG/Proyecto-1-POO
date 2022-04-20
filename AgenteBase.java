import java.util.Random;

import javax.swing.JButton;

import java.awt.Color;

public class AgenteBase {
    private int fila;
    public Color color;
    private int columna;
    int filaC;
    int columnac;
    int coordFAm;
    int coordCAm;
    int ultimaposF;
    int ultimaposC;
    private String posicion;
    private Random rand = new Random();
    private String[] posiciones = {"ARRIBA","ABAJO","IZQUIERDA","DERECHA","ARI","ARD","ABI","ABD"};
    private int pos = rand.nextInt(posiciones.length);
    int posFt;
    int posCt;
    int posF;
    int posC;
    boolean obs;
    boolean amen;
    boolean recur;
    boolean llevaR;
    
    public AgenteBase(){
        posicion = posiciones[pos];
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
        obs = false;
        amen = false;
        recur = false;
        llevaR = false;
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
       // Base.pintarBase();
        System.out.println(hormiga[Matriz.i] + hormiga[Matriz.i].posicion);
        ultimaposF = hormiga[Matriz.i].fila;
        ultimaposC = hormiga[Matriz.i].columna;
        System.out.println(ultimaposF + " " + ultimaposC);
        buscarRecurso(hormiga);
        System.out.println(hormiga[Matriz.i].amen);
        System.out.println(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].getBackground());
        if(hormiga[Matriz.i].amen == true){
            if(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].getBackground().equals(Color.red)){
                System.out.println("entro");
                if(coordFAm < hormiga[Matriz.i].fila && coordCAm < hormiga[Matriz.i].columna){
                    Matriz.bMatriz[hormiga[Matriz.i].fila-1][hormiga[Matriz.i].columna-1].setBackground(color);
                }
                else if(coordFAm > hormiga[Matriz.i].fila && coordCAm > hormiga[Matriz.i].columna){
                    Matriz.bMatriz[hormiga[Matriz.i].fila+1][hormiga[Matriz.i].columna+1].setBackground(color);
                }
                else if(coordFAm > hormiga[Matriz.i].fila && coordCAm < hormiga[Matriz.i].columna){
                    Matriz.bMatriz[hormiga[Matriz.i].fila+1][hormiga[Matriz.i].columna-1].setBackground(color);
                }
                else if(coordFAm < hormiga[Matriz.i].fila && coordCAm > hormiga[Matriz.i].columna){
                    Matriz.bMatriz[hormiga[Matriz.i].fila-1][hormiga[Matriz.i].columna+1].setBackground(color);
                }
            }
            else{
                if(coordFAm < hormiga[Matriz.i].fila && coordCAm < hormiga[Matriz.i].columna){
                    Matriz.bMatriz[hormiga[Matriz.i].fila+1][hormiga[Matriz.i].columna+1].setBackground(color);
                }
                else if(coordFAm > hormiga[Matriz.i].fila && coordCAm > hormiga[Matriz.i].columna){
                    Matriz.bMatriz[hormiga[Matriz.i].fila-1][hormiga[Matriz.i].columna-1].setBackground(color);
                }
                else if(coordFAm > hormiga[Matriz.i].fila && coordCAm < hormiga[Matriz.i].columna){
                    Matriz.bMatriz[hormiga[Matriz.i].fila-1][hormiga[Matriz.i].columna+1].setBackground(color);
                }
                else if(coordFAm < hormiga[Matriz.i].fila && coordCAm > hormiga[Matriz.i].columna){
                    Matriz.bMatriz[hormiga[Matriz.i].fila+1][hormiga[Matriz.i].columna-1].setBackground(color);
                }
            }

        }
        else if(hormiga[Matriz.i].obs == true){

        }
        else if(hormiga[Matriz.i].recur == true){

        }
        else{
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
            else if(hormiga[Matriz.i].posicion.equals("ARI")){
                Matriz.bMatriz[hormiga[Matriz.i].fila-1][hormiga[Matriz.i].columna-1].setBackground(color);
                fila--;
                columna--;
            }
            else if(hormiga[Matriz.i].posicion.equals("ARD")){
                Matriz.bMatriz[hormiga[Matriz.i].fila-1][hormiga[Matriz.i].columna+1].setBackground(color);
                fila--;
                columna++;
            }
            else if(hormiga[Matriz.i].posicion.equals("ABI")){
                Matriz.bMatriz[hormiga[Matriz.i].fila+1][hormiga[Matriz.i].columna-1].setBackground(color);
                fila++;
                columna--;
            }
            else if(hormiga[Matriz.i].posicion.equals("ABD")){
                Matriz.bMatriz[hormiga[Matriz.i].fila+1][hormiga[Matriz.i].columna+1].setBackground(color);
                fila++;
                columna++;
            }
        }
        Matriz.bMatriz[hormiga[Matriz.i].ultimaposF][hormiga[Matriz.i].ultimaposC].setBackground(new java.awt.Color(0, 135, 6));
        pos = rand.nextInt(posiciones.length);
        posicion = posiciones[pos];
    }

    public void buscarRecurso(AgenteBase[] hormiga){
        posF = hormiga[Matriz.i].fila;
        posC = hormiga[Matriz.i].columna;
        posFt = posF - 3;
        posCt = posC -3;
        System.out.println("Fila otr " + hormiga[Matriz.i].posFt + "Fila "+ hormiga[Matriz.i].posF);
        while(posFt <= posF+3 ){
            System.out.println(hormiga[Matriz.i].posFt + " " + hormiga[Matriz.i].posC);
            if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posC].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].columna].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.i].obs = true;
                    System.out.println("Hay obs");
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].columna].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.i].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = posFt;
                    coordCAm = columna;
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].columna].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.i].recur = true;
                    System.out.println("Hay rec");
                }
            }
            posFt++;
        }
        System.out.println("Izquierda y derecha");
        while(posCt <= posC+3 ){
            System.out.println(hormiga[Matriz.i].posF + " " + hormiga[Matriz.i].posCt);
            if(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].posCt].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].posCt].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.i].obs = true;
                    System.out.println("Hay obs");
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].posCt].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.i].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = fila;
                    coordCAm = posCt;
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].posCt].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.i].recur = true;
                    System.out.println("Hay rec");
                }
            }
            posCt++;
        }
        posCt = posC - 3;
        posFt = posF -3;
        while(posCt <= posC+3 && posFt <= posF+3 ){
            System.out.println(hormiga[Matriz.i].posFt + " " + hormiga[Matriz.i].posCt);
            if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.i].obs = true;
                    System.out.println("Hay obs");
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.i].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = posFt;
                    coordCAm = posCt;
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.i].recur = true;
                    System.out.println("Hay rec");
                }
            }
            posCt++;
            posFt++;
        }
        posCt = posC + 3;
        posFt = posF -3;
        System.out.println("Diagonales");
        while(posCt >= posC-3 && posFt <= posF+3 ){
            System.out.println(hormiga[Matriz.i].posFt + " " + hormiga[Matriz.i].posCt);
            if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.i].obs = true;
                    System.out.println("Hay obs");
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.i].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = posFt;
                    coordCAm = posCt;
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.i].recur = true;
                    System.out.println("Hay rec");
                }
            }
            posCt--;
            posFt++;
        }
        /*posCt = posC + 2;
        posFt = posF -3;
        
        while(posFt < posF ){
            System.out.println(hormiga[Matriz.i].posFt + " " + hormiga[Matriz.i].posCt);
            if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground().equals(Color.gray))
                {  
                    obs = true;
                    System.out.println("Hay obs");
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground().equals(Color.yellow))
                {
                    amen = true;
                    System.out.println("Hay amen");
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].posFt][hormiga[Matriz.i].posCt].getBackground().equals(Color.MAGENTA))
                {  
                    recur = true;
                    System.out.println("Hay rec");
                }
            }
            posCt--;
            posFt++;
        }
        */
    }

}

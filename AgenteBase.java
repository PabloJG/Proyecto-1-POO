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
    int inicioF;
    int inicioC;
    int maxF;
    int maxC;
    boolean obs;
    boolean amen;
    boolean recur;
    boolean llevaR;
    
    public AgenteBase(){
        posicion = posiciones[pos];
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
        ultimaposF = 0;
        ultimaposC = 0;
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
        System.out.println("Aqui " + hormiga[Matriz.i].fila + " " + hormiga[Matriz.i].columna);
        buscarRecursos(hormiga);
        if(hormiga[Matriz.i].amen == true)
            amenEncont(hormiga);
        else if(hormiga[Matriz.i].obs == true)
            obsEncont(hormiga);
        else if(hormiga[Matriz.i].recur == true)
            recEncont(hormiga);
        else
            moverAleatorio(hormiga);
        Matriz.bMatriz[hormiga[Matriz.i].ultimaposF][hormiga[Matriz.i].ultimaposC].setBackground(new java.awt.Color(0, 135, 6));
        pos = rand.nextInt(posiciones.length);
        posicion = posiciones[pos];
    }

    public void buscarRecursos(AgenteBase[] hormiga){
        maxF = hormiga[Matriz.i].fila;
        maxC = hormiga[Matriz.i].columna;
        inicioF = maxF - 3;
        verAA(hormiga);
        System.out.println("Izquierda y derecha");
        inicioC = maxC -3;
        verID(hormiga);
        System.out.println("Diagonal de derecha abajo a izquierda");
        inicioC = maxC - 3;
        inicioF = maxF -3;
        verDDAbI(hormiga);
        System.out.println("Diagonal de derecha arriba a izquierda");
        inicioC = maxC + 3;
        inicioF = maxF -3;
        verDDArI(hormiga);
        
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

    public void amenEncont(AgenteBase[] hormiga){
        hormiga[Matriz.i].ultimaposF = hormiga[Matriz.i].fila;
        hormiga[Matriz.i].ultimaposC = hormiga[Matriz.i].columna;
        if(hormiga[Matriz.i].color.equals(color.red)){
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

    public void obsEncont(AgenteBase[] hormiga){
        hormiga[Matriz.i].ultimaposF = hormiga[Matriz.i].fila;
        hormiga[Matriz.i].ultimaposC = hormiga[Matriz.i].columna;
    }

    public void recEncont(AgenteBase[] hormiga){
        hormiga[Matriz.i].ultimaposF = hormiga[Matriz.i].fila;
        hormiga[Matriz.i].ultimaposC = hormiga[Matriz.i].columna;
    }

    public void moverAleatorio(AgenteBase[] hormiga){
        hormiga[Matriz.i].ultimaposF = hormiga[Matriz.i].fila;
        hormiga[Matriz.i].ultimaposC = hormiga[Matriz.i].columna;
        if(hormiga[Matriz.i].posicion.equals("ARRIBA")){
            fila++;
            fila = rangoValido(fila);
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(color);
        }
        else if(hormiga[Matriz.i].posicion.equals("ABAJO")){
            fila--;
            fila = rangoValido(fila);
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(color);
        }
        else if(hormiga[Matriz.i].posicion.equals("IZQUIERDA")){
            columna--;
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(color);
            
        }
        else if(hormiga[Matriz.i].posicion.equals("DERECHA")){
            columna++;
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(color);
        }  
        else if(hormiga[Matriz.i].posicion.equals("ARI")){
            fila--;
            columna--;
            fila = rangoValido(fila);
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(color);
        }
        else if(hormiga[Matriz.i].posicion.equals("ARD")){
            fila--;
            columna++;
            fila = rangoValido(fila);
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(color);
        }
        else if(hormiga[Matriz.i].posicion.equals("ABI")){
            fila++;
            columna--;
            fila = rangoValido(fila);
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(color);
        }
        else if(hormiga[Matriz.i].posicion.equals("ABD")){
            fila++;
            columna++;
            fila = rangoValido(fila);
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].columna].setBackground(color);
        }
    }

    public int rangoValido(int valor){
        if(valor < 0)
            valor = 0;
        else if(valor > 49)
            valor = 49;
        return valor;
    }

    public void verAA(AgenteBase[] hormiga){
        inicioF = rangoValido(inicioF);
        int maximo = maxF + 3;
        maximo = rangoValido(maximo);
        while(inicioF <= maximo){
            if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].maxC].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].columna].getBackground().equals(Color.gray)){  
                    hormiga[Matriz.i].obs = true;
                    System.out.println("Hay obs");
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].columna].getBackground().equals(Color.yellow)){
                    hormiga[Matriz.i].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = inicioF;
                    coordCAm = columna;
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].columna].getBackground().equals(Color.MAGENTA)){  
                    hormiga[Matriz.i].recur = true;
                    System.out.println("Hay rec");
                }
            }
            inicioF++;
        }
    }
    
    public void verID(AgenteBase[] hormiga){
        inicioC = rangoValido(inicioC);
        int maximo = maxC + 3;
        maximo = rangoValido(maximo);
        while(inicioC <= maximo){
            if(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].inicioC].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].inicioC].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.i].obs = true;
                    System.out.println("Hay obs");
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].inicioC].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.i].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = fila;
                    coordCAm = inicioC;
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].fila][hormiga[Matriz.i].inicioC].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.i].recur = true;
                    System.out.println("Hay rec");
                }
            }
            inicioC++;
        }
    }

    public void verDDAbI(AgenteBase[] hormiga){
        inicioF = rangoValido(inicioF);
        inicioC = rangoValido(inicioC);
        int maximoC = maxC + 3;
        int maximoF = maxF + 3;
        maximoC = rangoValido(maximoC);
        maximoF = rangoValido(maximoF);
        while(inicioC <= maximoC && inicioF <= maximoF){
            if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].inicioC].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].inicioC].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.i].obs = true;
                    System.out.println("Hay obs");
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].inicioC].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.i].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = inicioF;
                    coordCAm = inicioC;
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].inicioC].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.i].recur = true;
                    System.out.println("Hay rec");
                }
            }
            inicioC++;
            inicioF++;
        }
    }

    public void verDDArI(AgenteBase[] hormiga){
        inicioF = rangoValido(inicioF);
        inicioC = rangoValido(inicioC);
        int maximoC = maxC - 3;
        int maximoF = maxF + 3;
        maximoC = rangoValido(maximoC);
        maximoF = rangoValido(maximoF);
        while(inicioC >= maximoC && inicioF <= maximoF){
            if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].inicioC].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].inicioC].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.i].obs = true;
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].inicioC].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.i].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = inicioF;
                    coordCAm = inicioC;
                }
                if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].inicioC].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.i].recur = true;
                    System.out.println("Hay rec");
                }
            }
            inicioC--;
            inicioF++;
        }
    }

    

}

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
    private int pos;
    int inicioF;
    int inicioC;
    int maxF;
    int maxC;
    boolean obs;
    boolean amen;
    boolean recur;
    boolean llevaR;
    
    public AgenteBase(){
        posicion = posiciones[0];
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
        ultimaposF = 0;
        ultimaposC = 0;
        obs = false;
        amen = false;
        recur = false;
        llevaR = false;
    }

    public void pintarH(){
        System.out.println(fila + " " + columna);
        while(Matriz.bMatriz[fila][columna].getBackground() != Matriz.verde){
            fila = (int) (Math.random()*(48-1)) + 1;
            columna = (int) (Math.random()*(48-1)) + 1;
        }
        Matriz.bMatriz[fila][columna].setBackground(color);
    }

    public void mover(AgenteBase[] hormiga){ //Se mueven una por una las hormigas
        System.out.println("\nAqui " + hormiga[Matriz.i].fila + " " + hormiga[Matriz.i].columna);
        pos = rand.nextInt(posiciones.length); 
        posicion = posiciones[pos]; //Se selecciona aleatoriamente la direccion a la que se dirige
        buscarRecursos(hormiga);
        if(hormiga[Matriz.i].amen == true)
            amenEncont(hormiga);
        else if(hormiga[Matriz.i].obs == true)
            obsEncont(hormiga);
        else if(hormiga[Matriz.i].recur == true)
            recEncont(hormiga);
        else if(hormiga[Matriz.i].llevaR == true)
            ;
        else{
            System.out.println("aleatorio");
            moverPosiciones(hormiga);
        }
        //La posicion donde estaba anteriormente la hormiga se pone de color verde para no dejar un rastro
        Matriz.bMatriz[hormiga[Matriz.i].ultimaposF][hormiga[Matriz.i].ultimaposC].setBackground(new java.awt.Color(0, 135, 6));
        amen = false;
        obs = false;
        recur = false;
    }

    private void buscarRecursos(AgenteBase[] hormiga){
        maxF = hormiga[Matriz.i].fila;
        maxC = hormiga[Matriz.i].columna;
        inicioF = maxF - 3;
        verAA(hormiga); //ve hacia arriba y abajo
        System.out.println("Izquierda y derecha");
        inicioC = maxC -3;
        verID(hormiga); //ve hacia la izquierda y derecha
        System.out.println("Diagonal de derecha abajo a izquierda");
        inicioC = maxC - 3;
        inicioF = maxF -3;
        verDDAbI(hormiga); //ve en diagonal de la derecha inferior a la izquierda superior
        System.out.println("Diagonal de derecha arriba a izquierda");
        inicioC = maxC + 3;
        inicioF = maxF -3;
        verDDArI(hormiga); //ve en diagonal de la derecha superior a la izquierda inferior
    }

    public void amenEncont(AgenteBase[] hormiga){
        hormiga[Matriz.i].ultimaposF = hormiga[Matriz.i].fila;
        hormiga[Matriz.i].ultimaposC = hormiga[Matriz.i].columna;
        if(hormiga[Matriz.i].color.equals(color.red)){
            System.out.println("entro roja");
            if(coordCAm > hormiga[Matriz.i].columna && coordFAm == hormiga[Matriz.i].fila){
                posicion = posiciones[3];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordCAm < hormiga[Matriz.i].columna && coordFAm == hormiga[Matriz.i].fila){
                posicion = posiciones[2];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.i].fila && coordCAm == hormiga[Matriz.i].columna){
                posicion = posiciones[1];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.i].fila && coordCAm == hormiga[Matriz.i].columna){
                posicion = posiciones[0];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.i].fila && coordCAm < hormiga[Matriz.i].columna){
                posicion = posiciones[6];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.i].fila && coordCAm > hormiga[Matriz.i].columna){
                posicion = posiciones[7];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.i].fila && coordCAm < hormiga[Matriz.i].columna){
                posicion = posiciones[4];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.i].fila && coordCAm > hormiga[Matriz.i].columna){
                posicion = posiciones[5];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            
        }
        else{
            System.out.println("entro negra");
            if(coordCAm > hormiga[Matriz.i].columna && coordFAm == hormiga[Matriz.i].fila){
                posicion = posiciones[2];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordCAm < hormiga[Matriz.i].columna && coordFAm == hormiga[Matriz.i].fila){
                posicion = posiciones[3];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.i].fila && coordCAm == hormiga[Matriz.i].columna){
                posicion = posiciones[0];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.i].fila && coordCAm == hormiga[Matriz.i].columna){
                posicion = posiciones[1];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.i].fila && coordCAm < hormiga[Matriz.i].columna){
                posicion = posiciones[5];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.i].fila && coordCAm > hormiga[Matriz.i].columna){
                posicion = posiciones[4];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.i].fila && coordCAm < hormiga[Matriz.i].columna){
                posicion = posiciones[7];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.i].fila && coordCAm > hormiga[Matriz.i].columna){
                posicion = posiciones[6];
                System.out.println(hormiga[Matriz.i].posicion);
                moverPosiciones(hormiga);
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

    public void moverPosiciones(AgenteBase[] hormiga){
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

    public int rangoValido(int valor){ //No permite que ningun valor se salga de la matriz
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
                else if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].columna].getBackground().equals(Color.yellow)){
                    hormiga[Matriz.i].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = inicioF;
                    coordCAm = columna;
                }
                else if(Matriz.bMatriz[hormiga[Matriz.i].inicioF][hormiga[Matriz.i].columna].getBackground().equals(Color.MAGENTA)){  
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

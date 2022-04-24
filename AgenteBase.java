import java.util.Random;
import java.awt.Color;

public class AgenteBase {
    int fila;
    public Color color;
    int columna;
    Amenaza amenaza = IniciarComp.amenaza;
    Recursos recurso = IniciarComp.recurso;
    Obstaculos obstaculo = IniciarComp.obstaculo;
    int filaC;
    int columnac;
    int coordFAm;
    int coordCAm;
    int coordFOb;
    int coordCOb;
    int coordFRec;
    int coordCRec;
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
        Base.pintarBase(); //Se realiza para que si una hormiga entra en la base no se borre 
        //Obstaculos.obstac();
        pos = rand.nextInt(posiciones.length); 
        posicion = posiciones[pos]; //Se selecciona aleatoriamente la direccion a la que se dirige
        buscarRecursos(hormiga);
        if(hormiga[Matriz.nHormiga].amen == true)
            amenEncont(hormiga);
        else if(hormiga[Matriz.nHormiga].llevaR == true){
            System.out.println("hormiga con recurso" + hormiga[Matriz.nHormiga].llevaR);
            llevarRec(hormiga);
        }
        else if(hormiga[Matriz.nHormiga].obs == true)
            obsEncont(hormiga);
        else if(hormiga[Matriz.nHormiga].recur == true)
            recEncont(hormiga);
        else{
            moverPosiciones(hormiga);
        }
        amen = false;
        obs = false;
        recur = false;
    }

    private void buscarRecursos(AgenteBase[] hormiga){
        maxF = hormiga[Matriz.nHormiga].fila;
        maxC = hormiga[Matriz.nHormiga].columna;
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
        hormiga[Matriz.nHormiga].ultimaposF = hormiga[Matriz.nHormiga].fila;
        hormiga[Matriz.nHormiga].ultimaposC = hormiga[Matriz.nHormiga].columna;
        if(hormiga[Matriz.nHormiga].color.equals(color.red)){
            System.out.println("entro roja");
            if(coordCAm > hormiga[Matriz.nHormiga].columna && coordFAm == hormiga[Matriz.nHormiga].fila){
                posicion = posiciones[3];
                System.out.println("Hay amen" + coordFAm + coordCAm);
                if(coordFAm == hormiga[Matriz.nHormiga].fila && coordCAm == hormiga[Matriz.nHormiga].columna+1)
                    amenaza.ataca(coordFAm, coordCAm);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordCAm < hormiga[Matriz.nHormiga].columna && coordFAm == hormiga[Matriz.nHormiga].fila){
                posicion = posiciones[2];
                System.out.println("Hay amen" + coordFAm + coordCAm);
                if(coordFAm == hormiga[Matriz.nHormiga].fila && coordCAm == hormiga[Matriz.nHormiga].columna-1)
                    amenaza.ataca(coordFAm, coordCAm);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.nHormiga].fila && coordCAm == hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[1];
                System.out.println("Hay amen" + coordFAm + coordCAm);
                if(coordFAm == hormiga[Matriz.nHormiga].fila+1 && coordCAm == hormiga[Matriz.nHormiga].columna)
                    amenaza.ataca(coordFAm, coordCAm);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.nHormiga].fila && coordCAm == hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[0];
                System.out.println("Hay amen" + coordFAm + coordCAm);
                if(coordFAm == hormiga[Matriz.nHormiga].fila-1 && coordCAm == hormiga[Matriz.nHormiga].columna)
                    amenaza.ataca(coordFAm, coordCAm);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.nHormiga].fila && coordCAm < hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[6];
                System.out.println("Hay amen" + coordFAm + coordCAm);
                if(coordFAm == hormiga[Matriz.nHormiga].fila+1 && coordCAm == hormiga[Matriz.nHormiga].columna-1)
                    amenaza.ataca(coordFAm, coordCAm);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.nHormiga].fila && coordCAm > hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[7];
                System.out.println("Hay amen" + coordFAm + coordCAm);
                if(coordFAm == hormiga[Matriz.nHormiga].fila+1 && coordCAm == hormiga[Matriz.nHormiga].columna+1)
                    amenaza.ataca(coordFAm, coordCAm);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.nHormiga].fila && coordCAm < hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[4];
                System.out.println("Hay amen" + coordFAm + coordCAm);
                if(coordFAm == hormiga[Matriz.nHormiga].fila-1 && coordCAm == hormiga[Matriz.nHormiga].columna-1)
                    amenaza.ataca(coordFAm, coordCAm);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.nHormiga].fila && coordCAm > hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[5];
                System.out.println("Hay amen" + coordFAm + coordCAm);
                if(coordFAm == hormiga[Matriz.nHormiga].fila-1 && coordCAm == hormiga[Matriz.nHormiga].columna+1)
                    amenaza.ataca(coordFAm, coordCAm);
                else
                    moverPosiciones(hormiga);
            }
            
        }
        else{
            System.out.println("entro negra");
            if(coordCAm > hormiga[Matriz.nHormiga].columna && coordFAm == hormiga[Matriz.nHormiga].fila){
                posicion = posiciones[2];
                System.out.println(hormiga[Matriz.nHormiga].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordCAm < hormiga[Matriz.nHormiga].columna && coordFAm == hormiga[Matriz.nHormiga].fila){
                posicion = posiciones[3];
                System.out.println(hormiga[Matriz.nHormiga].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.nHormiga].fila && coordCAm == hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[0];
                System.out.println(hormiga[Matriz.nHormiga].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.nHormiga].fila && coordCAm == hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[1];
                System.out.println(hormiga[Matriz.nHormiga].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.nHormiga].fila && coordCAm < hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[5];
                System.out.println(hormiga[Matriz.nHormiga].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm > hormiga[Matriz.nHormiga].fila && coordCAm > hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[4];
                System.out.println(hormiga[Matriz.nHormiga].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.nHormiga].fila && coordCAm < hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[7];
                System.out.println(hormiga[Matriz.nHormiga].posicion);
                moverPosiciones(hormiga);
            }
            else if(coordFAm < hormiga[Matriz.nHormiga].fila && coordCAm > hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[6];
                System.out.println(hormiga[Matriz.nHormiga].posicion);
                moverPosiciones(hormiga);
            }
        }
    }

    public void obsEncont(AgenteBase[] hormiga){
        hormiga[Matriz.nHormiga].ultimaposF = hormiga[Matriz.nHormiga].fila;
        hormiga[Matriz.nHormiga].ultimaposC = hormiga[Matriz.nHormiga].columna;
        obstaculo.posiciones(coordFOb, coordCAm, hormiga[Matriz.nHormiga].fila, hormiga[Matriz.nHormiga].columna, hormiga);
        Matriz.bMatriz[hormiga[Matriz.nHormiga].obstaculo.moveF][hormiga[Matriz.nHormiga].obstaculo.moveC].setBackground(color);
    }

    public void llevarRec(AgenteBase[] hormiga){
        int BFila = Base.BFila;
        int BColumna = Base.BColumna;
        hormiga[Matriz.nHormiga].ultimaposF = hormiga[Matriz.nHormiga].fila;
            hormiga[Matriz.nHormiga].ultimaposC = hormiga[Matriz.nHormiga].columna;
            if(BColumna > hormiga[Matriz.nHormiga].columna && BFila == hormiga[Matriz.nHormiga].fila){
                posicion = posiciones[3];
                if(BFila == hormiga[Matriz.nHormiga].fila && BColumna == hormiga[Matriz.nHormiga].columna+1)
                    hormiga[Matriz.nHormiga].llevaR = false;
                else
                    moverPosiciones(hormiga);
            }
            else if(BColumna < hormiga[Matriz.nHormiga].columna && BFila == hormiga[Matriz.nHormiga].fila){
                posicion = posiciones[2];
                if(BFila == hormiga[Matriz.nHormiga].fila && BColumna == hormiga[Matriz.nHormiga].columna-1)
                    hormiga[Matriz.nHormiga].llevaR = false;
                else
                    moverPosiciones(hormiga);
            }
            else if(BFila > hormiga[Matriz.nHormiga].fila && BColumna == hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[1];
                if(BFila == hormiga[Matriz.nHormiga].fila+1 && BColumna  == hormiga[Matriz.nHormiga].columna)
                    hormiga[Matriz.nHormiga].llevaR = false;
                else
                    moverPosiciones(hormiga);
            }
            else if(BFila < hormiga[Matriz.nHormiga].fila && BColumna == hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[0];
                if(BFila == hormiga[Matriz.nHormiga].fila-1 && BColumna  == hormiga[Matriz.nHormiga].columna)
                    hormiga[Matriz.nHormiga].llevaR = false;
                else
                    moverPosiciones(hormiga);
            }
            else if(BFila > hormiga[Matriz.nHormiga].fila && BColumna < hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[6];
                if(BFila == hormiga[Matriz.nHormiga].fila+1 && BColumna  == hormiga[Matriz.nHormiga].columna-1)
                    hormiga[Matriz.nHormiga].llevaR = false;
                else
                    moverPosiciones(hormiga);
            }
            else if(BFila > hormiga[Matriz.nHormiga].fila && BColumna > hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[7];
                if(BFila == hormiga[Matriz.nHormiga].fila+1 && BColumna == hormiga[Matriz.nHormiga].columna+1)
                    hormiga[Matriz.nHormiga].llevaR = false;    
                else
                    moverPosiciones(hormiga);
            }
            else if(BFila < hormiga[Matriz.nHormiga].fila && BColumna < hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[4];
                if(BFila == hormiga[Matriz.nHormiga].fila-1 && BColumna == hormiga[Matriz.nHormiga].columna-1)
                    hormiga[Matriz.nHormiga].llevaR = false;
                else
                    moverPosiciones(hormiga);
            }
            else if(BFila < hormiga[Matriz.nHormiga].fila && BColumna > hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[5];
                if(BFila == hormiga[Matriz.nHormiga].fila-1 && BColumna == hormiga[Matriz.nHormiga].columna+1)
                    hormiga[Matriz.nHormiga].llevaR = false;
                else
                    moverPosiciones(hormiga);
            }
            recur = false;

    }

    public void recEncont(AgenteBase[] hormiga){
        if(llevaR == false){
            hormiga[Matriz.nHormiga].ultimaposF = hormiga[Matriz.nHormiga].fila;
            hormiga[Matriz.nHormiga].ultimaposC = hormiga[Matriz.nHormiga].columna;
            if(coordCRec > hormiga[Matriz.nHormiga].columna && coordFRec == hormiga[Matriz.nHormiga].fila){
                posicion = posiciones[3];
                System.out.println("Hay rec" + coordFRec + coordCRec);
                if(coordFRec == hormiga[Matriz.nHormiga].fila && coordCRec == hormiga[Matriz.nHormiga].columna+1)
                    recurso.recolecta(coordFRec, coordCRec, hormiga);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordCRec < hormiga[Matriz.nHormiga].columna && coordFRec == hormiga[Matriz.nHormiga].fila){
                posicion = posiciones[2];
                System.out.println("Hay rec" + coordFRec + coordCRec);
                if(coordFRec == hormiga[Matriz.nHormiga].fila && coordCRec == hormiga[Matriz.nHormiga].columna-1)
                    recurso.recolecta(coordFRec, coordCRec, hormiga);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFRec > hormiga[Matriz.nHormiga].fila && coordCRec == hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[1];
                System.out.println("Hay rec" + coordFRec + coordCRec);
                if(coordFRec == hormiga[Matriz.nHormiga].fila+1 && coordCRec == hormiga[Matriz.nHormiga].columna)
                    recurso.recolecta(coordFRec, coordCRec, hormiga);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFRec < hormiga[Matriz.nHormiga].fila && coordCRec == hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[0];
                System.out.println("Hay rec" + coordFRec + coordCRec);
                if(coordFRec == hormiga[Matriz.nHormiga].fila-1 && coordCRec == hormiga[Matriz.nHormiga].columna)
                    recurso.recolecta(coordFRec, coordCRec, hormiga);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFRec > hormiga[Matriz.nHormiga].fila && coordCRec < hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[6];
                System.out.println("Hay rec" + coordFRec + coordCRec);
                if(coordFRec == hormiga[Matriz.nHormiga].fila+1 && coordCRec == hormiga[Matriz.nHormiga].columna-1)
                    recurso.recolecta(coordFRec, coordCRec, hormiga);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFRec > hormiga[Matriz.nHormiga].fila && coordCRec > hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[7];
                System.out.println("Hay rec" + coordFRec + coordCRec);
                if(coordFRec == hormiga[Matriz.nHormiga].fila+1 && coordCRec == hormiga[Matriz.nHormiga].columna+1)
                    recurso.recolecta(coordFRec, coordCRec, hormiga);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFRec < hormiga[Matriz.nHormiga].fila && coordCRec < hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[4];
                System.out.println("Hay rec" + coordFRec + coordCRec);
                if(coordFRec == hormiga[Matriz.nHormiga].fila-1 && coordCRec == hormiga[Matriz.nHormiga].columna-1)
                recurso.recolecta(coordFRec, coordCRec, hormiga);
                else
                    moverPosiciones(hormiga);
            }
            else if(coordFRec < hormiga[Matriz.nHormiga].fila && coordCRec > hormiga[Matriz.nHormiga].columna){
                posicion = posiciones[5];
                System.out.println("Hay rec" + coordFRec + coordCRec);
                if(coordFRec == hormiga[Matriz.nHormiga].fila-1 && coordCRec == hormiga[Matriz.nHormiga].columna+1)
                    recurso.recolecta(coordFRec, coordCRec, hormiga);
                else
                    moverPosiciones(hormiga);
            }
        }
        else{
            recur = false;
            llevarRec(hormiga);
        }
    }

    public void moverPosiciones(AgenteBase[] hormiga){
        hormiga[Matriz.nHormiga].ultimaposF = hormiga[Matriz.nHormiga].fila;
        hormiga[Matriz.nHormiga].ultimaposC = hormiga[Matriz.nHormiga].columna;
        move(hormiga);
        //La posicion donde estaba anteriormente la hormiga se pone de color verde para no dejar un rastro
        if(hormiga[Matriz.nHormiga].ultimaposF == hormiga[Matriz.nHormiga].fila && hormiga[Matriz.nHormiga].ultimaposC == hormiga[Matriz.nHormiga].columna)
            ;
        else
            Matriz.bMatriz[hormiga[Matriz.nHormiga].ultimaposF][hormiga[Matriz.nHormiga].ultimaposC].setBackground(new java.awt.Color(0, 135, 6));
    }

    public void move(AgenteBase[] hormiga){
        if(hormiga[Matriz.nHormiga].posicion.equals("ARRIBA")){
            fila++;
            fila = rangoValido(fila);
            Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].columna].setBackground(color);
        }
        else if(hormiga[Matriz.nHormiga].posicion.equals("ABAJO")){
            fila--;
            fila = rangoValido(fila);
            Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].columna].setBackground(color);
        }
        else if(hormiga[Matriz.nHormiga].posicion.equals("IZQUIERDA")){
            columna--;
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].columna].setBackground(color);
            
        }
        else if(hormiga[Matriz.nHormiga].posicion.equals("DERECHA")){
            columna++;
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].columna].setBackground(color);
        }  
        else if(hormiga[Matriz.nHormiga].posicion.equals("ARI")){
            fila--;
            columna--;
            fila = rangoValido(fila);
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].columna].setBackground(color);
        }
        else if(hormiga[Matriz.nHormiga].posicion.equals("ARD")){
            fila--;
            columna++;
            fila = rangoValido(fila);
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].columna].setBackground(color);
        }
        else if(hormiga[Matriz.nHormiga].posicion.equals("ABI")){
            fila++;
            columna--;
            fila = rangoValido(fila);
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].columna].setBackground(color);
        }
        else if(hormiga[Matriz.nHormiga].posicion.equals("ABD")){
            fila++;
            columna++;
            fila = rangoValido(fila);
            columna = rangoValido(columna);
            Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].columna].setBackground(color);
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
            if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].maxC].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].columna].getBackground().equals(Color.yellow)){
                    hormiga[Matriz.nHormiga].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = inicioF;
                    coordCAm = columna;
                    System.out.println("Hay amen" + coordFAm + coordCAm);
                }
                else if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].columna].getBackground().equals(Color.MAGENTA)){  
                    hormiga[Matriz.nHormiga].recur = true;
                    System.out.println("Hay rec");
                    coordFRec = inicioF;
                    coordCRec = inicioC;
                }
                else if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].columna].getBackground().equals(Color.gray)){  
                    hormiga[Matriz.nHormiga].obs = true;
                    System.out.println("Hay obs");
                    coordFOb = inicioF;
                    coordCOb = inicioC;
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
            if(Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].inicioC].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].inicioC].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.nHormiga].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = fila;
                    coordCAm = inicioC;
                }
                else if(Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].inicioC].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.nHormiga].recur = true;
                    System.out.println("Hay rec");
                    coordFRec = inicioF;
                    coordCRec = inicioC;
                }
                else if(Matriz.bMatriz[hormiga[Matriz.nHormiga].fila][hormiga[Matriz.nHormiga].inicioC].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.nHormiga].obs = true;
                    System.out.println("Hay obs");
                    coordFOb = inicioF;
                    coordCOb = inicioC;
                    
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
            if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].inicioC].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].inicioC].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.nHormiga].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = inicioF;
                    coordCAm = inicioC;
                    System.out.println(coordFAm + coordCAm);
                }
                else if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].inicioC].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.nHormiga].recur = true;
                    System.out.println("Hay rec");
                    coordFRec = inicioF;
                    coordCRec = inicioC;
                }
                else if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].inicioC].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.nHormiga].obs = true;
                    System.out.println("Hay obs");
                    coordFOb = inicioF;
                    coordCOb = inicioC;
                    
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
            if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].inicioC].getBackground() != Matriz.verde){
                if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].inicioC].getBackground().equals(Color.yellow))
                {
                    hormiga[Matriz.nHormiga].amen = true;
                    System.out.println("Hay amen");
                    coordFAm = inicioF;
                    coordCAm = inicioC;
                    System.out.println("Hay amen" + coordFAm + coordCAm);
                }
                else if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].inicioC].getBackground().equals(Color.MAGENTA))
                {  
                    hormiga[Matriz.nHormiga].recur = true;
                    System.out.println("Hay rec");
                    coordFRec = inicioF;
                    coordCRec = inicioC;
                }
                else if(Matriz.bMatriz[hormiga[Matriz.nHormiga].inicioF][hormiga[Matriz.nHormiga].inicioC].getBackground().equals(Color.gray))
                {  
                    hormiga[Matriz.nHormiga].obs = true;
                    coordFOb = inicioF;
                    coordCOb = inicioC;
                    
                }
            }
            inicioC--;
            inicioF++;
        }
    }

    

}

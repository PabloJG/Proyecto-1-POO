import java.awt.Color;

public class Obstaculos {
    static Obstaculos[] obs;
    AgenteBase[] H = IniciarComp.agentes;
    private int fila;
    private int columna;
    int coordC1;
    int coordF1;
    int coordC2;
    int coordF2;
    int moveF;
    int moveC;

    public Obstaculos(Obstaculos[] obstaculos){
        obs = obstaculos;
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
        coordC1 = columna;
        coordF1 = fila;
        coordC2 = columna+1;
        coordF2 = fila+1;
    }

    public Obstaculos(){

    }

    public void pintarObs(int i){
        boolean libre = false;
        fila = (int) (Math.random()*(48-1)) + 1;
        columna = (int) (Math.random()*(48-1)) + 1;
        while(libre != true){
            if(Matriz.bMatriz[fila][columna].getBackground() != (Matriz.verde) || Matriz.bMatriz[fila][columna+1].getBackground() != (Matriz.verde) || Matriz.bMatriz[fila+1][columna+1].getBackground() != (Matriz.verde) || Matriz.bMatriz[fila+1][columna].getBackground() != (Matriz.verde)){
                fila = (int) (Math.random()*(48-1)) + 1;
                columna = (int) (Math.random()*(48-1)) + 1;
            }
            else{
                Matriz.bMatriz[fila][columna].setBackground(Color.gray);
                Matriz.bMatriz[fila][columna+1].setBackground(Color.gray);
                Matriz.bMatriz[fila+1][columna].setBackground(Color.gray);
                Matriz.bMatriz[fila+1][columna+1].setBackground(Color.gray);
                libre = true;
            }
        } 
    }

    public static void obstac(){
        int i = 0;
        while(i < 5){
            Matriz.bMatriz[obs[i].coordF1][obs[i].coordC1].setBackground(Color.gray);
            Matriz.bMatriz[obs[i].coordF1][obs[i].coordC2].setBackground(Color.gray);
            Matriz.bMatriz[obs[i].coordF2][obs[i].coordC1].setBackground(Color.gray);
            Matriz.bMatriz[obs[i].coordF2][obs[i].coordC2].setBackground(Color.gray);
            i++;
        }
    }

    public void guardar(int i){
        obs[i].coordC1 = columna;
        obs[i].coordF1 = fila;
        obs[i].coordC2 = columna+1;
        obs[i].coordF2 = fila+1;
    }

    public void posiciones(int F, int C, int posHF, int posHC, AgenteBase[] hormiga){
        int i = 0;
        while(i != 5){
            if(obs[i].coordC1 == C && obs[i].coordF1 == F){
                posNuevaH(posHF, posHC);
            }
            else if(obs[i].coordC1 == C && obs[i].coordF2 == F){
                posNuevaH(posHF, posHC);
            }
            else if(obs[i].coordC2 == C && obs[i].coordF1 == F){
                posNuevaH(posHF, posHC);
            }
            else if(obs[i].coordC2 == C && obs[i].coordF2 == F){
                posNuevaH(posHF, posHC);
            }
            else{
                H = IniciarComp.agentes;
                H[Matriz.nHormiga].moverPosiciones(hormiga);
            }
            i++;
        }
                
    }

    private void posNuevaH(int F, int C){
        if(Matriz.bMatriz[F+1][C].getBackground() != Color.gray){
            moveF = F++;
            moveC = C;
        }
        if(Matriz.bMatriz[F][C+1].getBackground() != Color.gray){
            moveF = F;
            moveC = C++;
        }
        if(Matriz.bMatriz[F-1][C].getBackground() != Color.gray){
            moveF = F--;
            moveC = C;
        }
        if(Matriz.bMatriz[F][C-1].getBackground() != Color.gray){
            moveF = F;
            moveC = C--;
        }
        if(Matriz.bMatriz[F+1][C-1].getBackground() != Color.gray){
            moveF = F++;
            moveC = C--;
        }
        if(Matriz.bMatriz[F-1][C+1].getBackground() != Color.gray){
            moveF = F--;
            moveC = C++;
        }
        if(Matriz.bMatriz[F-1][C-1].getBackground() != Color.gray){
            moveF = F--;
            moveC = C--;
        }
        if(Matriz.bMatriz[F+1][C+1].getBackground() != Color.gray){
            moveF = F++;
            moveC = C++;
        }
    }
}

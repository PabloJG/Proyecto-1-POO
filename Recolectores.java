public class Recolectores extends AgenteBase{
    int fila;
    int columna;
    Matriz agente;
    AgenteBase[] hormigaR;

    public Recolectores(Matriz matriz, AgenteBase[] recolectoras){
        hormigaR = recolectoras;
        agente = matriz;
    }
}

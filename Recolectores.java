public class Recolectores extends AgenteBase{
    int fila;
    int columna;
    Matriz agente;
    AgenteBase[] hormigaR;

    public Recolectores(AgenteBase[] recolectores){
        hormigaR = recolectores;
        tipo = "recolector";
        pintar();
    }
}

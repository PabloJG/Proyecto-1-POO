public class Recolectores extends AgenteBase{
    private AgenteBase[] hormigaR;

    public Recolectores(AgenteBase[] recolectores){
        hormigaR = recolectores;
        color = new java.awt.Color(255, 15, 0);
        pintar();
    }
}

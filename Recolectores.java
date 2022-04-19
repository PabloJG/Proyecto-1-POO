public class Recolectores extends AgenteBase{
    private AgenteBase[] hormigaR;

    public Recolectores(AgenteBase[] recolectores){
        hormigaR = recolectores;
        color = new java.awt.Color(0, 0, 0);
        pintar();
    }
}

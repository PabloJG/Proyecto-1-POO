import java.awt.Color;

public class Recolectores extends AgenteBase{
    private AgenteBase[] hormigaR;

    public Recolectores(AgenteBase[] recolectores){
        hormigaR = recolectores;
        color = Color.black;
        pintar();
    }
}

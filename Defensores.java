import java.awt.Color;

public class Defensores extends AgenteBase{
    private AgenteBase[] hormigaD;
    Color tipo;

    public Defensores(AgenteBase[] defensores){
        hormigaD = defensores;
        color = new java.awt.Color(0, 0, 0);
        pintar();
    }

    public void Atacar(){

    }
}


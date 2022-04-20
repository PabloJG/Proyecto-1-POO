import java.awt.Color;

public class Defensores extends AgenteBase{
    private AgenteBase[] hormigaD;
    Color tipo;

    public Defensores(AgenteBase[] defensores){
        hormigaD = defensores;
        color = Color.red;
        pintar();
    }

    public void Atacar(){

    }
}


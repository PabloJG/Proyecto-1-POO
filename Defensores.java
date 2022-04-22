import java.awt.Color;

public class Defensores extends AgenteBase{
    private AgenteBase[] hormigaD;

    public Defensores(AgenteBase[] defensores){
        hormigaD = defensores;
        color = Color.red;
        pintarH();
    }

    public void Atacar(){

    }
}


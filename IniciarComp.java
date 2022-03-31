public class IniciarComp {
    private AgenteBase[] agentes;
    private Matriz matriz;
    private Obstaculos obstaculos;
    private Base base;
    private Amenaza amenazas;
    private Recursos recursos;

    IniciarComp(){
        agentes = new AgenteBase[20];
        matriz = new Matriz(agentes);
        obstaculos = new Obstaculos();
        base = new Base();
        amenazas = new Amenaza();
        recursos = new Recursos();
        IniciarAgentes();
    }

    private void IniciarAgentes(){
        for(int i = 0; i<10; i++){
            agentes[i] = new Defensores(agentes);
        }
        for(int j = 10; j<20; j++){
            agentes[j] = new Recolectores(agentes);
        }
    }
}

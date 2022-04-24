public class IniciarComp {
    static AgenteBase[] agentes;
    private Matriz matriz;
    private Obstaculos[] obstaculos;
    private Base base;
    public static Amenaza[] amenazas;
    public static Recursos[] recursos;
    public static Amenaza amenaza = new Amenaza();
    public static Recursos recurso = new Recursos();
    public static Obstaculos obstaculo = new Obstaculos();

    IniciarComp(){
        amenazas = new Amenaza[10];
        agentes = new AgenteBase[30];
        matriz = new Matriz(agentes);
        obstaculos = new Obstaculos[5];
        base = new Base();
        recursos = new Recursos[10];
        IniciarAmenaza();
        IniciarRecurso();
        IniciarObstaculo();
        IniciarAgentes();
    }

    private void IniciarObstaculo(){
        for(int i = 0; i<5; i++){
            obstaculos[i] = new Obstaculos(obstaculos);
            obstaculo.pintarObs(i);
            obstaculo.guardar(i);
        }
    }

    private void IniciarAmenaza(){
        for(int i = 0; i<10; i++){
            amenazas[i] = new Amenaza(amenazas);
            amenaza.pintarAmen(i);
            amenaza.guardar(i);
        }
    }

    private void IniciarRecurso(){
        for(int i = 0; i<10; i++){
            recursos[i] = new Recursos(recursos);
            recurso.pintarRec(i);
        }
    }

    private void IniciarAgentes(){
        for(int i = 0; i<15; i++){
            agentes[i] = new Defensores(agentes);
        }
        for(int j = 15; j<30; j++){
            agentes[j] = new Recolectores(agentes);
        }
    }
}

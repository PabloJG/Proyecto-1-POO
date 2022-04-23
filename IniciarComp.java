public class IniciarComp {
    private AgenteBase[] agentes;
    private Matriz matriz;
    private Obstaculos obstaculos;
    private Base base;
    public static Amenaza[] amenazas;
    public static Recursos[] recursos;
    public static Amenaza amenaza = new Amenaza();
    public static Recursos recurso = new Recursos();

    IniciarComp(){
        amenazas = new Amenaza[10];
        agentes = new AgenteBase[20];
        matriz = new Matriz(agentes);
        obstaculos = new Obstaculos();
        base = new Base();
        recursos = new Recursos[10];
        IniciarAmenaza();
        IniciarRecurso();
        IniciarAgentes();
    }

    private void IniciarAmenaza(){
        for(int i = 0; i<10; i++){
            amenazas[i] = new Amenaza(amenazas);
            amenaza.guardar();
        }
    }

    private void IniciarRecurso(){
        for(int i = 0; i<10; i++){
            recursos[i] = new Recursos(recursos);
            recurso.guardar();
        }
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

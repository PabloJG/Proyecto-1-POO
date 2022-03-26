public class Main {
    public static void main(String[] args){
        AgenteBase[] agentes = new AgenteBase[20];
        Matriz matriz = new Matriz(agentes);
        Obstaculos obstaculos = new Obstaculos();
        Base base = new Base();
        Amenaza amenaza = new Amenaza();
        Recursos recursos = new Recursos();

        for(int i = 0; i<10; i++){
            agentes[i] = new Defensores(agentes);
        }
        for(int j = 10; j<20; j++){
            agentes[j] = new Recolectores(agentes);
        }
    }
}
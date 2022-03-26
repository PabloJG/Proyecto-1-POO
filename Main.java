public class Main {
    public static void main(String[] args){
        Matriz matriz = new Matriz();
        Obstaculos obstaculos = new Obstaculos(matriz);
        Base base = new Base(matriz);
        Amenaza amenaza = new Amenaza(matriz);
        Recursos recursos = new Recursos(matriz);
        AgenteBase[] agentes = new AgenteBase[20];

        for(int i = 0; i<10; i++){
            agentes[i] = new Defensores(matriz);
        }
        for(int j = 10; j<20; j++){
            agentes[j] = new Recolectores(matriz);
        }
    }
}

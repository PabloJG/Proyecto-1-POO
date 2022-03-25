public class Main {
    public static void main(String[] args){
        Matriz matriz = new Matriz();
        Obstaculos obstaculos = new Obstaculos(matriz);
        Base base = new Base(matriz);
        Amenaza amenaza = new Amenaza(matriz);
        Recursos recursos = new Recursos(matriz);
    }
}

public class test {

    public test() {

    }

    public static void main(String[] args) {
        hilosrunnable minihilos1 = new hilosrunnable("Hilo1");
        hilosrunnable minihilos2 = new hilosrunnable("Hilo2");
        minihilos1.ejecutarHilo();
        minihilos2.ejecutarHilo();
    }
}

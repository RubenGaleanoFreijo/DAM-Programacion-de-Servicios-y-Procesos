public class hilos extends Thread {

    public hilos(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i <= 30; i++) {
            System.out.println(this.getName() + " el contador " + i);
            // try {
            //     sleep((long) Math.random() * 1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
    }

    public static void main(String[] args) {
        hilos minihilos1 = new hilos("hilo1");
        hilos minihilos2 = new hilos("hilo2");
        minihilos1.setPriority(Thread.MIN_PRIORITY);
        minihilos2.setPriority(Thread.MAX_PRIORITY);
        minihilos1.start();
        minihilos2.start();
    }
}
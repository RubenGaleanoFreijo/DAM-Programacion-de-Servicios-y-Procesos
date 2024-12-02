import java.util.concurrent.Semaphore;

public class Semaforo {
    private static final Semaphore semaforo = new Semaphore(1); // permite máximo 3 hilos

    static class Tarea implements Runnable {
        private final String nombre;

        public Tarea(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            try {
                System.out.println(nombre + " esta esperando...");
                semaforo.acquire();
                System.out.println(nombre + " accedio al recurso");
                Thread.sleep((long) Math.random()); // Simula el uso del recurso
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(nombre + " libero el recurso");
                semaforo.release();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Tarea("Hilo " + i)).start();
        }
    }
}

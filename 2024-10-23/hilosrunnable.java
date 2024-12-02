public class hilosrunnable implements Runnable {

    private Thread hilo = null;

    public hilosrunnable(String name) {
        this.hilo = new Thread(this, name);
    }

    public void run() {
        for (int i = 0; i <= 30; i++) {
            System.out.println(this.hilo.getName() + " el contador " + i);
        }
    }

    public void ejecutarHilo(){
        this.hilo.start();
    }
}
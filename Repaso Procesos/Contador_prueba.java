//Crea una clase Contador con un método incrementar() que aumenta un contador global. 
//Crea 3 hilos que llamen a este método 100 veces cada uno. Sincroniza el método incrementar() para que el contador no tenga resultados incorrectos.

class Contador {

    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
    }

    public int getContador() {
        return contador;
    }
}

public class Contador_prueba extends Thread {

    private Contador contador = null;

    public Contador_prueba(String hiloNombre, Contador contador) {
        super(hiloNombre);
        this.contador = contador;
    }

    @Override
    public void run() {
        System.out.println (getName());
        for (int i = 0; i < 100; i++) {
            contador.incrementar();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        Contador_prueba h1 = new Contador_prueba("hilo1", contador);
        Contador_prueba h2 = new Contador_prueba("hilo2", contador);
        Contador_prueba h3 = new Contador_prueba("hilo3", contador);

        h1.start();
        h2.start();
        h3.start();

        h1.join();
        h2.join();
        h3.join();

        System.out.println("Contador final: " + contador.getContador());
    }
}

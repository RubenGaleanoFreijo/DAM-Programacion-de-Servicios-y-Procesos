//Crea tres hilos que cuenten hasta diez y muestren el número en la consola. 
//Cada hilo debe contar a una velocidad distinta, por ejemplo, 
//uno cada medio segundo, otro cada segundo, y otro cada dos segundos.

public class Ejercicio2Hilos extends Thread{
    
    // Clase que implementa el comportamiento de cada hilo
    static class Contador implements Runnable {
        private String nombre;
        private int velocidad;

        // Constructor para recibir el nombre del hilo y la velocidad
        public Contador(String nombre, int velocidad) {
            this.nombre = nombre;
            this.velocidad = velocidad;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Hilo " + nombre + ": " + i);
                try {
                    // El hilo se duerme por el tiempo especificado en milisegundos
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Crear tres hilos con diferentes velocidades
        Thread hilo1 = new Thread(new Contador("1", 500)); // Cuenta cada 500 ms (0.5 seg)
        Thread hilo2 = new Thread(new Contador("2", 1000)); // Cuenta cada 1000 ms (1 seg)
        Thread hilo3 = new Thread(new Contador("3", 2000)); // Cuenta cada 2000 ms (2 seg)

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("Todos los hilos han terminado.");
    }
}

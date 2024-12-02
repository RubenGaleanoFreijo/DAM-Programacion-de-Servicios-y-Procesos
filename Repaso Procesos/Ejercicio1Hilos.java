//Crea un programa en el que un hilo imprima "Hola desde un Hilo" en la consola cinco veces. 
//Usa Thread.sleep(1000) para que el hilo espere un segundo entre cada mensaje.
public class Ejercicio1Hilos extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hola Hilo");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.err.println("Hilo interrumpido");
            }
            }
    }

    public static void main(String[]args){
    Ejercicio1Hilos hilo = new Ejercicio1Hilos();
    hilo.start();

    System.err.println("Ha terminado");
    }     
}

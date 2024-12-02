import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();
        Scanner sc = new Scanner(System.in);

        // Crear tanques
        Tank[] tanques = new Tank[4]; // Array para almacenar los tanques

        // Bucle para introducir los nombres de los tanques
        for (int i = 0; i < 4; i++) {
            System.out.println("Introduzca el nombre del tanque " + (i + 1) + ":");
            String nombreTanque = sc.nextLine(); // Leemos el nombre de cada tanque
            tanques[i] = new Tank(nombreTanque, battlefield); // Creamos el tanque y lo almacenamos en el array
        }

        sc.close();
        // Añadir tanques al campo de batalla
        battlefield.addTank(tanques[0]);
        battlefield.addTank(tanques[1]);
        battlefield.addTank(tanques[2]);
        battlefield.addTank(tanques[3]);

        // Iniciar hilos
        Thread t1 = new Thread(tanques[0]);
        Thread t2 = new Thread(tanques[1]);
        Thread t3 = new Thread(tanques[2]);
        Thread t4 = new Thread(tanques[3]);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Esperar a que termine el juego
        while (battlefield.isGameRunning()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Fin del juego.");
    }
}

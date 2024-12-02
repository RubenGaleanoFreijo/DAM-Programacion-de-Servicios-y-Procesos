public class ContadorConHilos {

    private static int contador = 0;  // Contador compartido
    private static final Object lock = new Object();  // Objeto para sincronizar

    public static void main(String[] args) {
        
        // Crear 5 hilos con nombres específicos
        Thread[] hilos = new Thread[5];
        
        for (int i = 0; i < 5; i++) {
            int hiloId = i + 1;  // ID del hilo (1, 2, 3, 4, 5)
            hilos[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (lock) {
                            // Si el contador ha llegado a 20, terminamos
                            if (contador >= 20) {
                                break;
                            }
                            // Incrementamos el contador y lo mostramos
                            contador++;
                            // Imprimir el nombre del hilo y el valor del contador
                            System.out.println("Hilo " + hiloId + " ha contado: " + contador);
                        }
                        try {
                            // Dormir un poco para dar oportunidad a otros hilos a ejecutar
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            
            // Asignamos el nombre del hilo
            hilos[i].setName("Hilo " + hiloId);
            hilos[i].start();  // Iniciamos cada hilo
        }
        
        // Esperar a que todos los hilos terminen
        for (int i = 0; i < 5; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Contador final: " + contador);
    }
}


class Filosofo extends Thread {
    private int id;
    private Tenedor tenedorIzquierdo;
    private Tenedor tenedorDerecho;

    public Filosofo(int id, Tenedor tenedorIzquierdo, Tenedor tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                if (id % 2 == 0) {
                    // Filosofos pares primero toman el tenedor izquierdo
                    tomarTenedores(tenedorIzquierdo, tenedorDerecho);
                } else {
                    // Filosofos impares primero toman el tenedor derecho
                    tomarTenedores(tenedorDerecho, tenedorIzquierdo);
                }
                comer();
                soltarTenedores();
            }
        } catch (InterruptedException e) {
            System.out.println("Filosofo " + id + " ha sido interrumpido.");
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosofo " + id + " esta pensando.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void tomarTenedores(Tenedor primero, Tenedor segundo) {
        synchronized (primero) {
            System.out.println("Filosofo " + id + " tomo el primer tenedor.");
            synchronized (segundo) {
                System.out.println("Filosofo " + id + " tomo el segundo tenedor.");
            }
        }
    }

    private void comer() throws InterruptedException {
        System.out.println("Filosofo " + id + " esta comiendo.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void soltarTenedores() {
        System.out.println("Filosofo " + id + " solto ambos tenedores.");
    }
}

class Tenedor {}

public class Cena {
    public static void main(String[] args) {
        int numeroFilosofos = 5;
        Filosofo[] filosofos = new Filosofo[numeroFilosofos];
        Tenedor[] tenedores = new Tenedor[numeroFilosofos];

        for (int i = 0; i < numeroFilosofos; i++) {
            tenedores[i] = new Tenedor();
        }

        for (int i = 0; i < numeroFilosofos; i++) {
            Tenedor tenedorIzquierdo = tenedores[i];
            Tenedor tenedorDerecho = tenedores[(i + 1) % numeroFilosofos];

            filosofos[i] = new Filosofo(i, tenedorIzquierdo, tenedorDerecho);
            filosofos[i].start();
        }
    }
}
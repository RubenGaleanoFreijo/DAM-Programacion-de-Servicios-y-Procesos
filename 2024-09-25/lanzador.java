
import java.io.IOException;

public class lanzador {

    public void ejecutar(String ruta) {
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(ruta);
            pb.start();
            Process p = pb.start();
            System.out.println(p.info());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String ruta = "C:\\Windows\\System32\\calc.exe";
        lanzador l1 = new lanzador();
        lanzador l2 = new lanzador();

        l1.ejecutar(ruta);
        l2.ejecutar(ruta);

    }
}

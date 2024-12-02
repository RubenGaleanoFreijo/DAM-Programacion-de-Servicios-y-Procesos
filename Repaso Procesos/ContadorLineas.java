import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContadorLineas {

    public ContadorLineas() {
    }

    public void lanzarProcesos(){
        ProcessBuilder pb = new ProcessBuilder("cmd","/c", "find /c /v \"\" PruebaContarLineas.java");
        try {
            Process proceso = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ContadorLineas c = new ContadorLineas();
        c.lanzarProcesos();
    }
}
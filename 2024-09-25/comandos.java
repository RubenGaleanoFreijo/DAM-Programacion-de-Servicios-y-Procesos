import java.io.IOException;

public class comandos {

    public static void main(String[] args) {
        // Diferentes formas de pasar el comando a los constructores de ProcessBuilder
        // 1ª forma: usando una cadena. Falla con parámetros
        String command1 = "notepad.exe";
        ProcessBuilder pb = new ProcessBuilder(command1);
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
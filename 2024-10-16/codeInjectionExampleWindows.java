import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeInjectionExampleWindows {
    public static void main(String[] args) throws IOException {
        // Supongamos que este argumento proviene de una entrada del usuario
        String userInput = args[0];
        userInput = userInput.replace("&", "gale");

        // Vulnerable: el input del usuario se concatena directamente en el comando
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "echo " + userInput);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            // Imprime cada línea de la salida
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Espera a que el proceso termine y obtiene el código de salida
            int exitCode;
            try {
                exitCode = process.waitFor();
                System.out.println("\nEl proceso terminó con el código: " + exitCode);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
    }
}
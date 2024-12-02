import java.io.IOException;

public class processBuilderNotepadExample {

    public static void main(String[] args) {
        // Crea el proceso para abrir Notepad
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
        ProcessBuilder processBuilder2 = new ProcessBuilder("calc.exe");

        try {
            // Inicia el proceso
            Process process = processBuilder.start();

            // Espera a que el proceso termine
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Se ha ejecutado perfectamente \n" +"Codigo de exitCode: " + exitCode);

                    // Inicia el proceso
                    Process process2 = processBuilder2.start();
                    // Espera a que el proceso termine
                    exitCode = process2.waitFor();

                    if (exitCode == 0) {
                        System.out.println("Se ha ejecutado perfectamente \n" +"Codigo de exitCode: " + exitCode);
                    }else{
                        System.err.println("Error \n" + "Codigo de exitCode: " + exitCode);
                    }
                    
            }else{
                System.err.println("Error \n" + "Codigo de exitCode: " + exitCode);
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

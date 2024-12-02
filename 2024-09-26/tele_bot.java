
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class tele_bot {

    public static void main(String[] args) {
        String botToken = "7668872415:AAH-qLIRR0T_jrj4hEz4R3fqhBmCkeX-McU";
        String chatID = "5011093281";
        String messageText = "Beni gordito";

        try {
            // Ejecución del script PowerShell
            /* String[] command2 = {"powershell.exe", "-Command", "process.ps1"};
            ProcessBuilder pb = new ProcessBuilder(command2);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            
            Captura de la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
             */

            // Preparar la conexión para enviar el mensaje a Telegram
            String urlString = "https://api.telegram.org/bot" + botToken + "/sendMessage?chat_id=" + chatID + "&text=" + messageText;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Mensaje enviado exitosamente.");
                System.out.println(responseCode);
            } else {
                System.out.println("Error al enviar el mensaje.");
                System.out.println(responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

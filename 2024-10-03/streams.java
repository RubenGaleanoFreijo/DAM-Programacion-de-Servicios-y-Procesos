
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class streams {

    public static void main(String[] args) {

        String mensaje = "";
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        try {
            mensaje = reader.readLine();
            System.out.println(mensaje);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;

public class streamSalida {

    public static void main(String[] args) {

        File f = new File("Prueba1.md");
        try {
            FileInputStream fis = new FileInputStream(f);

            // Reads the first byte
            int i = fis.read();

            while (i != -1) {
                System.out.print((char) i);
                // Reads next byte from the file
                i = fis.read();
            }
            fis.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

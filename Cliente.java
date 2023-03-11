import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 5000;
        Socket socket = new Socket(host, puerto);
        System.out.println("Conexión establecida con el servidor.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        System.out.println("Mensaje enviado al servidor.");
        out.println("Hola servidor!");

        String respuesta = in.readLine();
        System.out.println("Respuesta del servidor: " + respuesta);
        in.close();
        out.close();
        socket.close();
    }
}
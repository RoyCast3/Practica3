import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println(
                    "Uso desde consola: Se requiere el host y el puerto de ambos servidores");
            System.exit(1);
        }
        String host = args[0];
        int puerto = Integer.parseInt(args[1]);
        Socket socket = new Socket(host, puerto);
        System.out.println("Programa Inicializado...");

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
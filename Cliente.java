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
        String respuesta;
        System.out.println("Programa Inicializado...");

        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        System.out.println("Solicitud enviada al servidor.");
        salida.println("Hola servidor!");

        while(true){
            respuesta = entrada.readLine();
            if (respuesta == null)
            break;
            System.out.println("Mensaje del Servidor: " + respuesta);
        }

        entrada.close();
        salida.close();
        socket.close();
    }
}
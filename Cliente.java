import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Se requieren dos numeros, intentalo de nuevo");
            System.exit(1);
        }
        System.out.println("Programa Inicializado...");

        String host = "localhost";
        int puerto = 5000;
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String[] mensaje = new String[4];
        System.out.println(num1);
        System.out.println(num2);
        Socket socket = new Socket(host, puerto);

        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        System.out.println("Solicitud enviada al servidor.");
        salida.println(num1);
        salida.println(num2);

        for (int x = 0; x < 4; x++) {
            mensaje[x] = entrada.readLine();
        }

        salida.println(mensaje[0]);
        System.out.println(mensaje[1]);
        salida.println(mensaje[2]);
        System.out.println(mensaje[3]);

        entrada.close();
        salida.close();
        socket.close();
        System.exit(0);
    }
}
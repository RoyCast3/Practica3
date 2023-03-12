import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Se requieren dos numeros, intentalo de nuevo");
            System.exit(1);
        }
        System.out.println("Programa Inicializado...");

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String[] mensaje = new String[4];
        Socket socket = new Socket("localhost", 5000);
        Socket socket2 = new Socket("192.168.0.30", 4000);

        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        BufferedReader entrada2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
        PrintWriter salida2 = new PrintWriter(new OutputStreamWriter(socket2.getOutputStream()), true);

        salida.println(num1);
        salida.println(num2);
        salida2.println(num1);
        salida2.println(num2);
        System.out.println("Solicitud enviada.");

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
        entrada2.close();
        salida2.close();
        socket2.close();
        System.exit(0);
    }
}
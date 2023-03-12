import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Se requiere un puerto");
            System.exit(1);
        }
        
        int port = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Servidor iniciado en el puerto "+ port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje;
            int o1, o2;
            mensaje = entrada.readLine();
            int num1 = Integer.parseInt(mensaje);
            mensaje = entrada.readLine();
            int num2 = Integer.parseInt(mensaje);
            mensaje = entrada.readLine();
            o1 = Integer.parseInt(mensaje);
            mensaje = entrada.readLine();
            o2 = Integer.parseInt(mensaje);

            HiloCliente hilo = new HiloCliente(socket, o1, num1, num2);
            HiloCliente hilo2 = new HiloCliente(socket, o2, num1, num2);

            hilo.start();
            hilo2.start();

            mensaje = entrada.readLine();
            System.out.println(mensaje);
            mensaje = entrada.readLine();
            System.out.println(mensaje);
        }
    }
}

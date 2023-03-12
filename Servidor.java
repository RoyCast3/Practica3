import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Servidor iniciado en el puerto 5000...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje;
            mensaje = entrada.readLine();
            int num1 = Integer.parseInt(mensaje);
            mensaje = entrada.readLine();
            int num2 = Integer.parseInt(mensaje);

            HiloCliente hilo = new HiloCliente(socket, 1, num1, num2);
            HiloCliente hilo2 = new HiloCliente(socket, 2, num1, num2);
            HiloCliente hilo3 = new HiloCliente(socket, 3, num1, num2);
            HiloCliente hilo4 = new HiloCliente(socket, 4, num1, num2);

            hilo.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();

            mensaje = entrada.readLine();
            System.out.println(mensaje);
            mensaje = entrada.readLine();
            System.out.println(mensaje);
        }
    }
}

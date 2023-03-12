import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Servidor iniciado en el puerto 5000...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado: " + socket.getInetAddress().getHostName());
            //Creando los hilos para las operaciones
            HiloCliente hilo = new HiloCliente(socket, 1, 10, 20);
            HiloCliente hilo2 = new HiloCliente(socket, 1, 10, 20);
            HiloCliente hilo3 = new HiloCliente(socket, 1, 10, 20);
            HiloCliente hilo4 = new HiloCliente(socket, 1, 10, 20);
            hilo.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();
        }
    }
}



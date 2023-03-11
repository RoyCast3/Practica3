import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Servidor iniciado en el puerto 5000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress().getHostName());

                HiloCliente hilo = new HiloCliente(socket);
                hilo.start();
            }
        }
    }
}

class HiloCliente extends Thread {
    private Socket socket;

    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            out.println("Conectado al Servidor!");

            while (true) {
                String mensaje = in.readLine();
                if (mensaje == null) break;
                System.out.println("Mensaje recibido del cliente: " + mensaje);
                out.println("Respuesta del servidor: " + mensaje.toUpperCase());
            }

            in.close();
            out.close();
            socket.close();
            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
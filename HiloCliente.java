import java.io.*;
import java.net.*;

class HiloCliente extends Thread {
    private Socket socket;
    private int opcion;

    public HiloCliente(Socket socket, int opcion) {
        this.socket = socket;
        this.opcion = opcion;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            out.println("Conectado al Servidor!");
            String mensaje;
            switch (opcion) {
                case 1:
                out.println("SE ELIGIÓ LA OPCION: " + opcion);
                    break;
                case 2:
                out.println("SE ELIGIÓ LA OPCION: " + opcion);
                    break;
                case 3:
                out.println("SE ELIGIÓ LA OPCION: " + opcion);
                    break;
                case 4:
                out.println("SE ELIGIÓ LA OPCION: " + opcion);
                    break;
            }

            while (true) {
                mensaje = in.readLine();
                if (mensaje == null)
                    break;
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

        int numero1 = 10;
        int numero2 = 5;
        int resultado = sumar(numero1, numero2);
        System.out.println("El resultado es: " + resultado);
    }

    
            
    public static int sumar(int a, int b) {
        int resultado = a + b;
        return resultado;
    }
}

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
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            salida.println("Conectado al Servidor!");
            String mensaje;
            switch (opcion) {
                case 1:
                    salida.println("SE ELIGIÓ LA OPCION: " + opcion);
                    break;
                case 2:
                    salida.println("SE ELIGIÓ LA OPCION: " + opcion);
                    break;
                case 3:
                    salida.println("SE ELIGIÓ LA OPCION: " + opcion);
                    break;
                case 4:
                    salida.println("SE ELIGIÓ LA OPCION: " + opcion);
                    break;
            }

            while (true) {
                mensaje = entrada.readLine();
                if (mensaje == null)
                    break;
                System.out.println("Mensaje recibido del cliente: " + mensaje);
                salida.println("Respuesta del servidor: " + mensaje.toUpperCase());
            }

            entrada.close();
            salida.close();
            socket.close();
            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * int numero1 = 10;
     * int numero2 = 5;
     * int resultado = sumar(numero1, numero2);
     * System.out.println("El resultado es: " + resultado);
     * 
     * public static int sumar(int a, int b) {
     * int resultado = a + b;
     * return resultado;
     * }
     */
}

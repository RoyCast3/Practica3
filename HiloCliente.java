import java.io.*;
import java.net.*;

class HiloCliente extends Thread {
    private Socket socket;
    private int opcion;
    private int num1;
    private int num2;

    public HiloCliente(Socket socket, int opcion, int num1, int num2) {
        this.socket = socket;
        this.opcion = opcion;
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            String mensaje;
            salida.println("Conectado al Servidor!");

            mensaje = entrada.readLine();
            System.out.println("Mensaje del cliente: " + mensaje);
            switch (opcion) {
                case 1:
                    int resultado = sumar(num1, num2);
                    salida.println("El total de la suma es: " + resultado);
                    break;
                case 2:
                    resultado = resta(num1, num2);
                    salida.println("El total de la suma es: " + resultado);
                    break;
                case 3:
                    resultado = multiplicar(num1, num2);
                    salida.println("El total de la suma es: " + resultado);
                    break;
                case 4:
                    resultado = dividir(num1, num2);
                    salida.println("El total de la suma es: " + resultado);
                    break;
            }

            entrada.close();
            salida.close();
            socket.close();
            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int sumar(int a, int b) {
        int total = a + b;
        return total;
    }
    private static int resta(int a, int b) {
        int total = a - b;
        return total;
    }
    private static int dividir(int a, int b) {
        int total = a / b;
        return total;
    }
    private static int multiplicar(int a, int b) {
        int total = a * b;
        return total;
    }

}

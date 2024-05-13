import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class servidor {

    public static void main(String[] args) {

        //Crear socket para el servidor 
        ServerSocket socket_servidor;
        try {
            socket_servidor = new ServerSocket(2305);
            System.out.println("Esperando conexiones...");
            Socket socket_cliente = socket_servidor.accept();

            /* ------------------------------- Creacion de Buffer para recibir y enviar datos al cliente (Hilos) -------------------------------------- */

            //Sirve para almacenar el flujo de info que envia el cliente (recibir)
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));

            //Sirve para enviar los datos que enviare (salida)
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);

            //Leer los datos recibidos por el cliente, almacenados en entrada 
            String datos_recibidos = entrada.readLine();
            System.out.println("El mensaje recibido es: " + datos_recibidos);

            //Escribir los datos a enviar en salida 
            String mensaje_enviar = "Hola soy el servidor";
            salida.println(mensaje_enviar);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
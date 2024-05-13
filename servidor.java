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
        try {
            ServerSocket socket_servidor = new ServerSocket(2305);
            System.out.println("Esperando conexiones...");

            while (true) {
                Socket socket_cliente = socket_servidor.accept();
                hiloCliente hilo = new hiloCliente(socket_cliente);   
                hilo.start ();  
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
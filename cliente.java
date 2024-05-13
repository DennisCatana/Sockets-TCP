import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class cliente {
    public static void main(String[] args) {
 
        //Crear socket para el servidor 
        Socket socket_cliente;

        try {
            //Crear socket para el cliente 
            socket_cliente = new Socket("localhost", 2305); //Cambiar por IP de mi compañera 
            System.out.println("Cliente conectado");

            /* ------------------------------- Creacion de Buffer para recibir y enviar datos al cliente (Hilos) -------------------------------------- */

            //Sirve para almacenar el flujo de info que envia el cliente (recibir)
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));

            //Sirve para enviar los datos que enviare (salida)
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);

            //Escribir los datos a enviar en salida 
            String mensaje_enviar = "Hola soy el cliente";
            salida.println(mensaje_enviar);

            //Leer los datos recibidos por el cliente, almacenados en entrada 
            String datos_recibidos = entrada.readLine();
            System.out.println("El mensaje recibido es: " + datos_recibidos);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

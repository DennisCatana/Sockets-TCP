import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class hiloCliente extends Thread {

    Socket socket_cliente;

    public hiloCliente(Socket socket_cliente){
        this.socket_cliente = socket_cliente;
    }

    public void run(){
        try{
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

        } catch (IOException e){
            e.printStackTrace();


        }
        
    }
    
    
}

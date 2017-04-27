
package chatservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author netosolis
 */
public class HiloServidor implements Runnable{
    //Declaramos las variables que utiliza el hilo para estar recibiendo y mandando mensajes
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    //Lista de los usuarios conectados al servidor
    private LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
    
    //Constructor que recibe el socket que atendera el hilo y la lista de usuarios conectados
    public HiloServidor(Socket soc,LinkedList users){
        socket = soc;
        usuarios = users;
    }

   
    
    
    @Override
    public void run() {
        try {
            //Inicializamos los canales de comunicacion y mandamos un mensaje de bienvenida
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("<h1>Bienvenido....</h1>");
            //Ciclo infinito para escuchar por mensajes del cliente
            while(true){
               String recibido = in.readUTF();
               //Cuando se recibe un mensaje se envia a todos los usuarios conectados 
                for (int i = 0; i < usuarios.size(); i++) {
                    out = new DataOutputStream(usuarios.get(i).getSocket().getOutputStream());
                    out.writeUTF(recibido);
                 
                }
            }
        } catch (IOException e) {
            //Si ocurre un excepcion lo mas seguro es que sea por que el cliente se desconecto asi que lo quitamos de la lista de conectados
            for (int i = 0; i < usuarios.size(); i++) {
                if(usuarios.get(i).getSocket() == socket){
                    usuarios.remove(i);
                    break;
                } 
            }
        }
    }
}

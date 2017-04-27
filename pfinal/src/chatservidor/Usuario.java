package chatservidor;


import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flavio A. Pareja
 */
public class Usuario {
    
    private Socket socket; 
    private String Nombre; 

    public Usuario(Socket socket, String Nombre) {
        this.socket = socket;
        this.Nombre = Nombre;
    }

    
    
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
    
}

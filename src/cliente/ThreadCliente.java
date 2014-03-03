/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensaje.Mensaje;

/**
 *
 * @author Diego F. Vanegas
 */
class ThreadCliente extends Thread
{

    private int id;
    private int puertoConexion;
    private String dirConexion;
    private Socket s;

    ThreadCliente(int idThread, int PUERTO, String DIR_IP) throws IOException
    {
        id = idThread;
        puertoConexion = PUERTO;
        dirConexion = DIR_IP;
    }
    
    public void enviarMensaje(Socket s)
    {
        new Mensaje(s);
    }

    public void run()
    {
        try
        {
            s = new Socket(dirConexion, puertoConexion);
            enviarMensaje(s);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensaje;

import java.net.Socket;

/**
 *
 * @author Diego F. Vanegas
 */
public class Mensaje
{
    Socket socket;

    public Mensaje(Socket s)
    {
        socket = s;
    }
    
    public void enviar()
    {
        
    }
}

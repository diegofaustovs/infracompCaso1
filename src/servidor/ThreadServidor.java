/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Diego F. Vanegas
 */
class ThreadServidor extends Thread
{

    Socket socketEntrada;
    int id;

    public ThreadServidor(Socket accept, int idThread)
    {
        socketEntrada = accept;
        id = idThread;
    }

    public void run()
    {
        boolean ejecutar = true;
        String mensajeIn, mensajeOut;
        System.out.println("Inicio de nuevo thread con id " + id);

        try
        {
            PrintWriter escritor = new PrintWriter(socketEntrada.getOutputStream(), true);
            BufferedReader lector = new BufferedReader(new InputStreamReader(socketEntrada.getInputStream()));
            Protocolo protocol = new Protocolo();
            mensajeOut = protocol.procesar(null);
            escritor.println(mensajeOut);

            while ((mensajeIn = lector.readLine()) != null && ejecutar)
            {
                mensajeOut = protocol.procesar(mensajeIn);
                escritor.println(mensajeOut);
                if (mensajeOut.equals(Protocolo.TERMINAR))
                {
                    ejecutar = false;
                }

                escritor.close();
                lector.close();
                socketEntrada.close();

            }
        } 
        
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

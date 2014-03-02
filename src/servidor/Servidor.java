package servidor;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Diego F. Vanegas
 */
public class Servidor
{

    public final static int PUERTO = 1234;

    public static void main(String[] args) throws IOException
    {
        ServerSocket ss = null;
        boolean continuar = true;
        int idThread = 0;

        try
        {
             ss = new ServerSocket(PUERTO);
        } 
        catch (Exception e)
        {
            System.err.println("No se pudo crear el socket en el puerto: " + PUERTO);
            System.exit(-1);
        }
        
        while (continuar)
        {
            new ThreadServidor(ss.accept(), idThread).start();
            idThread ++;
        }
        
        ss.close();

    }
}

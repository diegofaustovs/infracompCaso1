/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;

/**
 *
 * @author Diego F. Vanegas
 */
public class ClienteColpensiones
{
    public final static int PUERTO = 2;
    public final static String DIR_IP = "127.0.0.1";

    public static void main(String[] args) throws IOException
    {
        int idThread = 0;
        boolean continuar = true;

        while (continuar)
        {
            new ThreadCliente(idThread, PUERTO, DIR_IP).start();
            idThread ++;
        }
    }
}

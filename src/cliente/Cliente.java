/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Diego F. Vanegas
 */
public class Cliente
{

    public final static String IP = "127.0.0.1";
    public final static int PUERTO = 45405;

    public static void main(String[] args) throws IOException
    {
        boolean ejecutar = true;
        Socket socketSalida = null;
        PrintWriter escritor = null;
        BufferedReader lector = null;

        try
        {
            socketSalida = new Socket(IP, PUERTO);
            escritor = new PrintWriter(socketSalida.getOutputStream(), true);
            lector = new BufferedReader(new InputStreamReader(socketSalida.getInputStream()));
        }
        catch (Exception e)
        {
            System.err.println("Exception: " + e.getMessage());
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer, fromUser;

        while ((fromServer = lector.readLine()) != null && ejecutar)
        {
            System.out.println("Servidor: " + fromServer);
            if (fromServer.equalsIgnoreCase("Terminar"))
            {
                ejecutar = false;
            }

            if (ejecutar)
            {
                fromUser = stdIn.readLine();
                if (fromUser != null)
                {
                    System.out.println("Cliente: " + fromUser);
                    escritor.println(fromUser);
                }
            }
        }

        escritor.close();
        lector.close();
        socketSalida.close();
        stdIn.close();
    }
}

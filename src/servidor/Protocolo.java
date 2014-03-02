/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author Diego F. Vanegas
 */
class Protocolo
{

    public static final
            String TERMINAR = "Terminar";
    public static final
            String EN_ESPERA = "En Espera";
    public static final
            String EMPEZAR = "Empezar";
    public static final
            String LEER = "Leer";
    public static final
            String ADIOS = "Adieu";
    private
            String estado;

    public
            Protocolo()
    {
        estado = EN_ESPERA;
    }

    public String procesar(String entrada)
    {
        String salida = "";

        if (estado == EN_ESPERA)
        {
            salida = EMPEZAR;
            estado = LEER;
        }

        else if (estado == LEER)
        {
            if (entrada.equalsIgnoreCase(ADIOS))
            {
                estado = TERMINAR;
                salida = ADIOS;
            }
            else
            {
                salida = "Reportando Entrada " + entrada;
            }
        }

        return salida;
    }

}

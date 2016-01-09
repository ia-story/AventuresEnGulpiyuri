package util;

/**
 * Created by Maria on 09/01/2016.
 */
public class Configuracion {
    private static Configuracion ourInstance = new Configuracion();

    public static Configuracion getInstance() {
        return ourInstance;
    }
    private static boolean lecturaAutomatica = false;
    private static boolean repetirAviso = true;

    private Configuracion() {}
    public static void setLecturaAutomatica (boolean activado){lecturaAutomatica=activado;}
    public static boolean getLecturaAutomatica(){return lecturaAutomatica;}
    public static void setRepetirAviso (boolean repetir){repetirAviso=repetir;}
    public static boolean getRepetirAviso(){return repetirAviso;}
}

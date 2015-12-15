package util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import audiovisuales.aventuresengulpiyuri.Portada;
import audiovisuales.aventuresengulpiyuri.R;

/**
 * Created by Maria on 12/12/2015.
 */
public class Utilidades {
    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // Aunque sea deprecated hay que dejarlo por la API mínima que manejamos
        //Mirar si hay Wifi o GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }

    /* Diálogo que se mostrará cada vez que se abre una nueva página y no se detecta coe
     */
    public static void mostrarVentanaErrorDeConexion(Context context) {
        new AlertDialog.Builder(context)
                .setTitle(R.string.tituloFalloConexion)
                .setMessage(R.string.mensajeFalloConexion)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .show();
    }


    public static void mostrarVentanaLecturaAutomatica(Context context) {
        new AlertDialog.Builder(context)
                .setTitle(R.string.activarLecturaAutomatica)
                .setMessage(R.string.mensajeLecturaAutomatica)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Portada.setLecturaAutomatica(true);
                    }
                })
                .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Portada.setLecturaAutomatica(false);
                    }
                })
                .show();
    }
}

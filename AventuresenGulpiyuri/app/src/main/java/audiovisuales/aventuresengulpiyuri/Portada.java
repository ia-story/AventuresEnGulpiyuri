package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import util.Utilidades;

public class Portada extends ActionBarActivity {

    private static boolean lecturaAutomatica=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_portada);
        Utilidades.mostrarVentanaLecturaAutomatica(this);
    }

    public void pasaPagina(View view){
        Intent mIntent=new Intent(Portada.this, PaginaPrimera.class);
        startActivity(mIntent);

        finish(); // Cierra la actividad actual, si no se van acumulando unas encima de otras
    }

    public static void setLecturaAutomatica (boolean activado){
        lecturaAutomatica=activado;
    }
    public static boolean getLecturaAutomatica(){
        return lecturaAutomatica;
    }
}

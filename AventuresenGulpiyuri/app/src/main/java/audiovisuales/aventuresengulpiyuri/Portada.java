package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import util.Utilidades;

public class Portada extends ActionBarActivity {

    private static boolean lecturaAutomatica=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
        Utilidades.mostrarVentanaLecturaAutomatica(this);
    }

    public void pasaPagina(View view){
        Intent mIntent=new Intent(Portada.this, PaginaPrimera.class);
        startActivity(mIntent);
    }

    public static void setLecturaAutomatica (boolean activado){
        lecturaAutomatica=activado;
    }
    public static boolean getLecturaAutomatica(){
        return lecturaAutomatica;
    }
}

package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import util.Utilidades;

public class Portada extends AppCompatActivity {

    private static boolean lecturaAutomatica=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
        Utilidades.mostrarVentanaLecturaAutomatica(this);
    }

    public void pasaPagina(View view){
        Intent mIntent= new Intent(Portada.this, PaginaPrimera.class);
        startActivity(mIntent);
    }


    public static void setLecturaAutomatica (boolean activado){
        lecturaAutomatica=activado;
    }

    public static boolean getLecturaAutomatica(){
        return lecturaAutomatica;
    }

}

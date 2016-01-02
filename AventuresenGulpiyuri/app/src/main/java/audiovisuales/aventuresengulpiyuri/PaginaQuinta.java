package audiovisuales.aventuresengulpiyuri;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import util.Utilidades;

public class PaginaQuinta extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_quinta);
        if (!Utilidades.verificaConexion(this)){
            Utilidades.mostrarVentanaErrorDeConexion(this);
        }
    }
}

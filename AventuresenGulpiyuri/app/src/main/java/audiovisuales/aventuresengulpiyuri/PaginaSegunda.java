package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class PaginaSegunda extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pagina_segunda);
    }

    public void irAJuego2(View view){
        Intent mIntent= new Intent(PaginaSegunda.this, JuegoPregunta.class);
        startActivity(mIntent);

        finish(); // Cierra la actividad actual, si no se van acumulando unas encima de otras
    }
}

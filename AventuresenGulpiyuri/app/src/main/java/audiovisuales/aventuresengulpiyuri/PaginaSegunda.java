package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class PaginaSegunda extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_segunda);
    }

    public void irAJuego2(View view){
        Intent mIntent= new Intent(PaginaSegunda.this, JuegoPregunta.class);
        startActivity(mIntent);
    }
}

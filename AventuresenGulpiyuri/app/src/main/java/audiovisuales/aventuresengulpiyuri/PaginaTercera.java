package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class PaginaTercera extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_tercera);
    }

    public void irAPagina4(View view){
        Intent mIntent = new Intent(PaginaTercera.this, PaginaCuarta.class);
        startActivity(mIntent);
    }
}

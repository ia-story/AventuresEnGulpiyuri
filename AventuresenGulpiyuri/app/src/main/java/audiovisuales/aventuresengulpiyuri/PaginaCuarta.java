package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class PaginaCuarta extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pagina_cuarta);
    }

    public void  irAJuego3 (View view){
        Intent mIntent = new Intent (PaginaCuarta.this, JuegoGestos.class);
        startActivity(mIntent);
        finish();
    }
}

package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.nfc.tech.TagTechnology;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import util.Utilidades;

public class PaginaTercera extends ActionBarActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_pagina_tercera);

        if (!Utilidades.verificaConexion(this)){
            Utilidades.mostrarVentanaErrorDeConexion(this);
        }
        else if(Portada.getLecturaAutomatica()){
            tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    tts.speak(getResources().getString(R.string.terceraPaginaTTS), TextToSpeech.QUEUE_ADD, null);
                }});
        }
    }

    public void irAPagina4(View view){
        Intent mIntent = new Intent(PaginaTercera.this, PaginaCuarta.class);
        startActivity(mIntent);

        finish(); // Cierra la actividad actual, si no se van acumulando unas encima de otras
    }
}

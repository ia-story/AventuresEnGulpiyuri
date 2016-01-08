package audiovisuales.aventuresengulpiyuri;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.HashMap;
import java.util.Locale;

import util.Utilidades;

public class PaginaPrimera extends ActionBarActivity{
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pagina_primera);
        if (!Utilidades.verificaConexion(this)){
            Utilidades.mostrarVentanaErrorDeConexion(this);
        }
        else if(Portada.getLecturaAutomatica()){
           tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
               @Override
               public void onInit(int status) {
                   tts.setSpeechRate(Float.valueOf("0.95"));
                   tts.speak(getResources().getString(R.string.primeraPagina), TextToSpeech.QUEUE_ADD, null);
               }});
        }
    }

    public void pasaPagina(View view){
        //Hay que cambiarlo para que vaya a la página del juego de la linterna
        Intent mIntent = new Intent(PaginaPrimera.this, PaginaSegunda.class);
        if (tts!=null)
            tts.stop();
        startActivity(mIntent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

        finish(); // Cierra la actividad actual, si no se van acumulando unas encima de otras
    }

    @Override
    public void onBackPressed() {
        if (tts!=null)
            tts.stop();
        finish();
    }
}

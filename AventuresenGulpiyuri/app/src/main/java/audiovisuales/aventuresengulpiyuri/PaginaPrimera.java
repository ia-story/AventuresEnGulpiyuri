package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import util.Utilidades;

public class PaginaPrimera extends ActionBarActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_primera);
        if (!Utilidades.verificaConexion(this)){
            Utilidades.mostrarVentanaErrorDeConexion(this);
        }
        //SIGUE SIN FUNCIONAR, NO VEO EL FALLO
        else if(Portada.getLecturaAutomatica()){
            tts = new TextToSpeech(this, this);
            tts.speak(getResources().getString(R.string.primeraPagina), TextToSpeech.QUEUE_ADD, null);
        }
    }

    public void pasaPagina(View view){
        //Hay que cambiarlo para que vaya a la página del juego de la linterna
        Intent mIntent = new Intent(PaginaPrimera.this, PaginaSegunda.class);
        startActivity(mIntent);

    }

    @Override
    public void onInit(int status) {}
}

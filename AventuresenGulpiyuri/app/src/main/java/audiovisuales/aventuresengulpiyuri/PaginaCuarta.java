package audiovisuales.aventuresengulpiyuri;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import util.Utilidades;

public class PaginaCuarta extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_cuarta);

        if (!Utilidades.verificaConexion(this)){
            Utilidades.mostrarVentanaErrorDeConexion(this);
        }
        else if(Portada.getLecturaAutomatica()){
            tts= new TextToSpeech(this, this);
            //Por la API mínima que usamos tenemos que usar el método deprecated
            tts.speak(getResources().getString(R.string.cuartaPaginaTTS), TextToSpeech.QUEUE_ADD, null);
        }
    }

    @Override
    public void onInit(int status) {}
}

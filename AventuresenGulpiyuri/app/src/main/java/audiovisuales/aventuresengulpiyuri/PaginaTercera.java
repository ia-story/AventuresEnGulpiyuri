package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import util.Utilidades;

public class PaginaTercera extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_tercera);

        if (!Utilidades.verificaConexion(this)){
            Utilidades.mostrarVentanaErrorDeConexion(this);
        }
        else if(Portada.getLecturaAutomatica()){
            tts= new TextToSpeech(this, this);
            //Por la API mínima que usamos tenemos que usar el método deprecated
            tts.speak(getResources().getString(R.string.terceraPaginaTTS), TextToSpeech.QUEUE_ADD, null);
        }
    }

    public void irAPagina4(View view){
        Intent mIntent = new Intent(PaginaTercera.this, PaginaCuarta.class);
        startActivity(mIntent);
    }
    @Override
    public void onInit(int status) { }
}

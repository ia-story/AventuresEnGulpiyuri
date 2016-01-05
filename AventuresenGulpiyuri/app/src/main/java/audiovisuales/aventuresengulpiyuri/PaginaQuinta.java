package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import util.Utilidades;

public class PaginaQuinta extends ActionBarActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pagina_quinta);
        if (!Utilidades.verificaConexion(this)){
            Utilidades.mostrarVentanaErrorDeConexion(this);
        }
        else if(Portada.getLecturaAutomatica()){
            tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    tts.setSpeechRate(Float.valueOf("0.90"));
                    tts.speak(getResources().getString(R.string.quintaPaginaTTS), TextToSpeech.QUEUE_ADD, null);
                }});
        }
    }

    public void irAFin(View view){
        Intent mIntent = new Intent(PaginaQuinta.this, Fin.class);
        tts.stop();
        startActivity(mIntent);
        finish();
    }
}

package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import util.Utilidades;

public class PaginaSegunda extends ActionBarActivity {

    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pagina_segunda);

        if (!Utilidades.verificaConexion(this)){
            Utilidades.mostrarVentanaErrorDeConexion(this);
        }
        else if(Portada.getLecturaAutomatica()){
            tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    tts.setSpeechRate(Float.valueOf("0.90"));
                    tts.speak(getResources().getString(R.string.segundaPaginaTTS), TextToSpeech.QUEUE_ADD, null);
                }});
        }
    }

    public void irAJuego2(View view){
        Intent mIntent= new Intent(PaginaSegunda.this, JuegoPregunta.class);
        tts.stop();
        startActivity(mIntent);

        finish();
    }
}

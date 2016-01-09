package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import util.Configuracion;
import util.Utilidades;

public class PaginaPrimera extends ActionBarActivity{
    private TextToSpeech tts;
    private Configuracion conf = Configuracion.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pagina_primera);
        if (conf.getLecturaAutomatica()){
            if (!Utilidades.verificaConexion(this)) {
                if (conf.getRepetirAviso())
                    Utilidades.mostrarVentanaErrorDeConexion(this);
            }
            else {
                tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        tts.setSpeechRate(Float.valueOf("0.95"));
                        tts.speak(getResources().getString(R.string.primeraPaginaTTS), TextToSpeech.QUEUE_ADD, null);
                    }
                });
            }
        }
    }

    public void pasaPagina(View view){
        //Hay que cambiarlo para que vaya a la página del juego de la linterna
        Intent mIntent = new Intent(PaginaPrimera.this, JuegoOscuridad.class);
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

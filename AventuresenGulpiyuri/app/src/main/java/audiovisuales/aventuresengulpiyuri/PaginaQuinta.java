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

public class PaginaQuinta extends ActionBarActivity {

    private TextToSpeech tts;
    private Configuracion conf = Configuracion.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pagina_quinta);
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
                        tts.speak(getResources().getString(R.string.quintaPaginaTTS), TextToSpeech.QUEUE_FLUSH, null);
                    }
                });
            }
        }
    }

    public void irAFin(View view){
        Intent mIntent = new Intent(PaginaQuinta.this, Fin.class);
        if (tts!=null)
            tts.stop();
        startActivity(mIntent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (tts!=null)
            tts.stop();
        finish();
    }
}

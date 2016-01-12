package audiovisuales.aventuresengulpiyuri;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import util.Configuracion;
import util.Utilidades;

public class Fin extends ActionBarActivity {

    private TextToSpeech tts;
    private Configuracion conf = Configuracion.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_fin);
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
                        tts.speak(getResources().getString(R.string.fin), TextToSpeech.QUEUE_ADD, null);
                    }
                });
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (tts!=null)
            tts.stop();
        finish();
    }
}

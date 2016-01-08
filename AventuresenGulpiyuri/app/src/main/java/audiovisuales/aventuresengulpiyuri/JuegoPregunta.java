package audiovisuales.aventuresengulpiyuri;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import logica.LogicaPregunta;

public class JuegoPregunta extends ActionBarActivity {

    private LogicaPregunta logica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_juego_pregunta);
        logica=LogicaPregunta.getInstance();
        ((TextView)findViewById(R.id.txPregunta)).setText(logica.getPregunta().getEnunciado());
        ((Button)findViewById(R.id.btRespuesta1)).setText(logica.getPregunta().getRespuesta(0));
        ((Button)findViewById(R.id.btRespuesta2)).setText(logica.getPregunta().getRespuesta(1));
        ((Button)findViewById(R.id.btRespuesta3)).setText(logica.getPregunta().getRespuesta(2));
        ((ImageView)findViewById(R.id.imageView)).setBackgroundResource(logica.getPregunta().getImagen());
    }

    public void comprobar(View view){
        Intent mIntent=null;
        if(logica.respuestaCorrecta(((Button)view).getText().toString())) {
            mIntent = new Intent(JuegoPregunta.this, PaginaTercera.class);
        }
        if(mIntent != null) {
            startActivity(mIntent);
            overridePendingTransition(R.anim.left_in, R.anim.left_out);
            finish(); // Cierra la actividad actual, si no se van acumulando unas encima de otras
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.entrugaIncorreuta)
                    .setMessage(R.string.pruebaOtraVez)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
    }
}

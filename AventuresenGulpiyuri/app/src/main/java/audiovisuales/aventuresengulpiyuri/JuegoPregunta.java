package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import logica.LogicaPregunta;

public class JuegoPregunta extends ActionBarActivity {

    private LogicaPregunta logica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        startActivity(mIntent);
    }
}

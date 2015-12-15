package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import logica.LogicaPregunta;

public class JuegoPregunta extends AppCompatActivity {

    private LogicaPregunta logica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_pregunta);
        logica=LogicaPregunta.getInstance();
        ((EditText)findViewById(R.id.txPregunta)).setText(logica.getPregunta().getEnunciado());
        ((Button)findViewById(R.id.btRespuesta1)).setText(logica.getPregunta().getRespuesta(0));
        ((Button)findViewById(R.id.btRespuesta2)).setText(logica.getPregunta().getRespuesta(1));
        ((Button)findViewById(R.id.btRespuesta3)).setText(logica.getPregunta().getRespuesta(2));
        ((ImageView)findViewById(R.id.imageView)).setBackgroundResource(logica.getPregunta().getImagen());
    }

    public void irAPagina3(View view){
        Intent mIntent= new Intent(JuegoPregunta.this, PaginaTercera.class);
        startActivity(mIntent);
    }

}

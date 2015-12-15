package audiovisuales.aventuresengulpiyuri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JuegoPregunta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_pregunta);
    }

    public void irAPagina3(View view){
        Intent mIntent= new Intent(JuegoPregunta.this, PaginaTercera.class);
        startActivity(mIntent);
    }

}

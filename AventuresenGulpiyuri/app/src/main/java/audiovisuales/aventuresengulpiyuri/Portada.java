package audiovisuales.aventuresengulpiyuri;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import util.Utilidades;

public class Portada extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_portada);
        Utilidades.mostrarVentanaLecturaAutomatica(this);
    }

    public void pasaPagina(View view){
        Intent mIntent=new Intent(Portada.this, PaginaPrimera.class);
        startActivity(mIntent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

        finish();
    }


}

package audiovisuales.aventuresengulpiyuri;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

import util.Utilidades;

public class JuegoGestos extends ActionBarActivity implements GestureOverlayView.OnGesturePerformedListener {

    private GestureOverlayView gesture;
    private GestureLibrary glibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new AlertDialog.Builder(this)
                .setTitle(R.string.TituloJuego3)
                .setMessage(R.string.enunciadoJuego3)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .show();
        setContentView(R.layout.activity_juego_gestos);
        gesture = (GestureOverlayView)findViewById(R.id.gestureOverlayView1);
        gesture.addOnGesturePerformedListener(this);
        glibrary = GestureLibraries.fromRawResource(this, R.raw.gesture);
        glibrary.load();
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = glibrary.recognize(gesture);
        if (predictions.size()>0){
            Prediction prediction = predictions.get(0);
            if (prediction.score > 1.5) {
               Toast.makeText(this,prediction.name,Toast.LENGTH_LONG).show();
               if (prediction.name.equals("6"))
                    cambiarDePagina();
                else
                    Utilidades.preguntaFallada(this);
            }else{
                new AlertDialog.Builder(this)
                        .setTitle(R.string.irreconocible)
                        .setMessage(R.string.escribeOtraVez)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        }
    }

    private void cambiarDePagina(){
        Intent mIntenn = new Intent(JuegoGestos.this, PaginaQuinta.class);
        startActivity(mIntenn);
        finish();
    }
}

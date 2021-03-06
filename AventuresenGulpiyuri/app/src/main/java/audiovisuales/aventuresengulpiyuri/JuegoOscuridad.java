package audiovisuales.aventuresengulpiyuri;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class JuegoOscuridad extends Activity {
    int width = 1;
    int height = 1;
    private boolean paginaPasada = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new TouchView(this));

    }

    class TouchView extends View {
        Bitmap bgr;
        Bitmap overlayDefault;
        Bitmap overlay_mutable;
        Paint pTouch;
        int X = -100;
        int Y = -100;
        Canvas c2;

        public TouchView(Context context) {
            super(context);

            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            width = size.x;
            height = size.y;

            bgr = BitmapFactory.decodeResource(getResources(), R.drawable.xana);
            bgr = Bitmap.createScaledBitmap(bgr, width, height, false);
            overlayDefault =     BitmapFactory.decodeResource(getResources(), R.drawable.oscuridad);
            overlayDefault = Bitmap.createScaledBitmap(overlayDefault, width, height, false);
            overlay_mutable = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);  // convert to ARGB_8888 format,only den can it be put on canvas in next line..
            c2 = new Canvas();
            c2.setBitmap(overlay_mutable);
            c2.drawBitmap(overlayDefault, 0, 0, null);

            pTouch = new Paint(Paint.ANTI_ALIAS_FLAG);
            pTouch.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            pTouch.setAlpha(0);
            pTouch.setColor(Color.TRANSPARENT);
            pTouch.setMaskFilter(new BlurMaskFilter(15, BlurMaskFilter.Blur.NORMAL));


        }

        @Override
        public boolean onTouchEvent(MotionEvent ev) {

            switch (ev.getAction()) {

                case MotionEvent.ACTION_DOWN: {

                    X = (int) ev.getX();
                    Y = (int) ev.getY();
                    invalidate();

                    break;
                }

                case MotionEvent.ACTION_MOVE: {

                    X = (int) ev.getX();
                    Y = (int) ev.getY();
                    invalidate();
                    break;

                }

                case MotionEvent.ACTION_UP:

                    break;

            }
            return true;
        }


        @Override
        public void onDraw(Canvas canvas){
            super.onDraw(canvas);

            //draw background
            canvas.drawBitmap(bgr, 0, 0, null);
            //copy the default overlay into temporary overlay and punch a hole in it
            c2.drawBitmap(overlayDefault, 0, 0, null); //exclude this line to show all as you draw
            c2.drawCircle(X, Y, 80, pTouch);
            //draw the overlay over the background
            canvas.drawBitmap
                    (overlay_mutable, 0, 0, null);
            if(X>(0.7*width) && X < (0.74*width) && Y>(0.26*height) && Y < (0.32*height) && !paginaPasada) {
                paginaPasada = true;
                pasaPagina();
            }

        }

    }

    public void pasaPagina(){
        //Hay que cambiarlo para que vaya a la página del juego de la linterna
        Intent mIntent = new Intent(JuegoOscuridad.this, PaginaSegunda.class);

        startActivity(mIntent);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

        finish(); // Cierra la actividad actual, si no se van acumulando unas encima de otras
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.salirOSiguiente)
                .setPositiveButton(R.string.siguiente, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        pasaPagina();
                    }
                })
                .setNegativeButton(R.string.salir, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .show();
    }
}

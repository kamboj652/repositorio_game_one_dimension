package com.gameonedimension.myapplication.pintado;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.gameonedimension.myapplication.R;
import com.gameonedimension.myapplication.dimensions.OneDimensionRespuesta;
import com.gameonedimension.myapplication.dimensions.OneDimensionSolucion;
import com.gameonedimension.myapplication.juego.Coordenada;
import com.gameonedimension.myapplication.juego.ElementoOneDimension;
import com.gameonedimension.myapplication.juego.Pieza;
import com.gameonedimension.myapplication.juego.PiezaMoveThread;

public class LienzoGameView extends SurfaceView implements SurfaceHolder.Callback {

    //hilo del juego, detiene y reanuda el hilo pieza para pintar la pantalla
  //  private OneDimensionGameThread paintThread;
    //hilo qye mueve la pieza
    //private PiezaMoveThread bolaThread;
    private Paint paint = new Paint();
    private Paint paint_2 = new Paint();
    private final int colorBloques;
    private final int nivel;
    //Handler handler;

    private ElementoOneDimension bola;

    Bitmap bmp;
    final Context activoty;
   // private Thread gameThread;
 //   private OneDimensionGameThread paintThread;
   //hilo del juego, detiene y reanuda el hilo pieza para pintar la pantalla
   private OneDimensionGameThread paintThread;
    //hilo qye mueve la pieza
    private PiezaMoveThread bolaThread;
    //Constructor
    public LienzoGameView(Context context, final int nivel, final int colorBloques) {

        super(context);
        this.colorBloques = colorBloques;
        this.nivel = nivel;
        this.activoty = context;
        //this.handler=handler;
        switch (this.nivel) {

            case 0:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.a);
                break;
            case 1:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.v);
                break;
            case 2:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.z);
                break;
            case 3:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.t);
                break;
            case 4:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.tenedor);
                break;
            case 5:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.hueso);
                break;
            case 6:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.peine);
                break;
            case 7:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.corazon);
                break;
            case 8:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.tijeras);
                break;
            case 9:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.estrella);
                break;
            case 10:
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ojo);
                break;
            default: {
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.fin);
                break;

            }

        }
        getHolder().addCallback(this);
        this.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View clicked) {

                surfaceDestroyed(null);
                finalizar();
            }
        });

    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //objeto que cruzará
        bola = new Pieza(new Coordenada(0,0),getHeight()/2,getWidth()/2,bmp);
        //Hilo del juego mierdero
        paintThread = new OneDimensionGameThread(getHolder(), this);
        //dentro de el se bloqueara y desbloqueara el hilo usando el getHolder
        paintThread.setRunning(true);
        paintThread.start();

        //Hilo de la pelota
        bolaThread = new PiezaMoveThread((Pieza) bola);
        bolaThread.setRunning(true);
        bolaThread.start();


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        //boolean retry = true;
        paintThread.setRunning(false);
        bolaThread.setRunning(false);


    }

    @Override
    public void onDraw(Canvas canvas) {


        //tinta la linea
        paint.setColor(Color.WHITE);
        //tinta los bloques
        paint_2.setColor(colorBloques);
        //pinta el hueco que dejan los objetos
        canvas.drawColor(colorBloques);
        //linea central
        //canvas.drawRect(184, 0, 185, 350, paint);
        canvas.drawRect(379, 0, 381.25f, 550, paint);
        if (bola.getOrigenX()<=400){
            //canvas.drawBitmap(bmp, bola.getOrigenX(), 0, paint);
            canvas.drawBitmap(bmp, bola.getOrigenX(), 30, paint);
            //1º bloque
            canvas.drawRect(0, 0, 379, 550, paint_2);

            //2º bloque
            canvas.drawRect(381.25f, 0,getWidth(),getHeight(), paint_2);

        }
        else
        {

            surfaceDestroyed(this.getHolder());
            finalizar();

        }


    }

    public void finalizar() {

        if (colorBloques == Color.BLACK) {
            Intent resolver = new Intent(activoty, OneDimensionRespuesta.class);
            resolver.putExtra("lvl", nivel);
            resolver.putExtra("color", 0xf8999999);
            activoty.startActivity(resolver);
        } else

        {
            Intent siguiente = new Intent(activoty, OneDimensionSolucion.class);
            siguiente.putExtra("lvl", nivel);
            siguiente.putExtra("color", Color.BLACK);
            activoty.startActivity(siguiente);
        }

        //surfaceDestroyed(null);
        if (activoty instanceof Activity) {
            ((Activity) activoty).finish();
        }

    }


}
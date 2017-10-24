package com.gameonedimension.myapplication.dimensions;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.gameonedimension.myapplication.R;
import com.gameonedimension.myapplication.serviciomusica.MusicaSingleton;


public class OneDimensionFIN extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.creditosmuypre);
        final ImageView imagen = new ImageView(this);
        imagen.setImageBitmap(bmp);

        setContentView(imagen);

        new Handler().postDelayed
                (
                        new Runnable() {
                            public void run() {
                                imagen.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.creditosprev));
                                setContentView(imagen);

                            }
                        }, 4000
                );

        final MusicaSingleton musica = MusicaSingleton.getInstance();
        musica.stopMusic();
        musica.setMusic(R.raw.azodfinal, getApplicationContext());
        musica.playMusic();


        imagen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                musica.destroyMusic();
                finish();
            }
        });

    }
}

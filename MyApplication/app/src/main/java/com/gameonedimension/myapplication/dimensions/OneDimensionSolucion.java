package com.gameonedimension.myapplication.dimensions;


import com.gameonedimension.myapplication.pintado.LienzoGameView;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.graphics.Color;

public class OneDimensionSolucion extends Activity {

    MediaPlayer musica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onStart() {
        super.onStart();

        int lvl = getIntent().getExtras().getInt("lvl") + 1;

        if (lvl >= 11) {

            final Intent inten = new Intent(this, OneDimensionFIN.class);
            startActivity(inten);
            finish();

        } else {
            setContentView(new LienzoGameView(this, lvl, Color.BLACK));
        }


    }


}

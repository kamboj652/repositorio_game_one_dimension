package com.azzvl.onedimension;

import com.azzvl.onedimension.R;
import com.azzvl.onedimension.serviciomusica.MusicaSingleton;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;



public class OneDimensionvCActivity extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.main);
      
        final MusicaSingleton musica=MusicaSingleton.getInstance();
        musica.setMusic(R.raw.azodinicio, getApplicationContext());
        musica.playMusic();
				        
        //obtenemos el TextView del botón para aplicarle el evento on Click
		TextView play = (TextView)findViewById(R.id.play_button);
		TextView quit= (TextView)findViewById(R.id.quit_button);
		
		
		play.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), R.string.menu_play, Toast.LENGTH_SHORT).show();
				
				musica.stopMusic();
				musica.setMusic(R.raw.azodjuego, getApplicationContext());
				musica.playMusic();
				
				empiezaJuego();
			 }
		});
		
		quit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), R.string.menu_play, Toast.LENGTH_SHORT).show();
				musica.destroyMusic();
				finish();
			 }
		});
        

    }
    
	public void empiezaJuego() {
		
		Intent juego = new Intent(this, OneDimensionJuego.class);
		juego.putExtra("lvl", 0);
		juego.putExtra("color", 0xf8999999);
		
		this.startActivity(juego);
		finish();
		
	}
	
	
	
}
package com.azzvl.onedimension;

import com.azzvl.onedimension.pintado.LienzoGameView;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;




import android.view.Window;

public class OneDimensionJuego extends Activity {
	
	int lvl,color;
	MediaPlayer musica;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);			
		lvl=getIntent().getExtras().getInt("lvl");
	    color=getIntent().getExtras().getInt("color");          
	}
	
	
	@Override
	protected void onStart() {
		super .onStart();
		setContentView(new LienzoGameView(this,lvl,color));	     
	}
	 
	

}
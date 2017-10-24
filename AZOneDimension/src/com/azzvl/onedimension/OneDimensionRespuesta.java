package com.azzvl.onedimension;



import com.azzvl.onedimension.serviciomusica.MusicaSingleton;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class OneDimensionRespuesta extends Activity {
	
	int lvl;
	int color;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	
		
		lvl=getIntent().getExtras().getInt("lvl");
		color=getIntent().getExtras().getInt("color");
		
		setContentView(R.layout.respuesta);
		
		TextView aceptar = (TextView)findViewById(R.id.aceptar);
		TextView repetir = (TextView)findViewById(R.id.repetir);
		TextView salir=(TextView)findViewById(R.id.salir);
		
		final EditText solucion= (EditText) findViewById(R.id.txt_message);
		
		final Intent juego= new Intent(this,OneDimensionJuego.class);		
		
				
		aceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
							
				switch (lvl){
				case 0: 
					 if(solucion.getText().toString().toLowerCase().equals("a")){
						 nextLevel(juego);}						 
				     break;
				
					case 1:
						 if(solucion.getText().toString().toLowerCase().equals("v")){
							 nextLevel(juego);}
						 break;
					case 2:
						 if(solucion.getText().toString().toLowerCase().equals("z")){
							 nextLevel(juego);}
						 break;
					case 3:
						 if(solucion.getText().toString().toLowerCase().equals("?")){
							 nextLevel(juego);}
						 break;
					case 4:
						 if(solucion.getText().toString().toLowerCase().equals("tenedor")){
							 nextLevel(juego);}
						 break;
						
					case 5:
						
						 if(solucion.getText().toString().toLowerCase().equals("hueso")){
							 nextLevel(juego);}
						 break;
					case 6:
						 if(solucion.getText().toString().toLowerCase().equals("peine")){
							 nextLevel(juego);
							 }
						break;
					case 7:
						 if(solucion.getText().toString().toLowerCase().equals("corazon")){
							 nextLevel(juego);}
						break;
					case 8:
						 if(solucion.getText().toString().toLowerCase().equals("tijeras")){
							 nextLevel(juego);}
						break;
					case 9:
						 if(solucion.getText().toString().toLowerCase().equals("estrella")){
							 nextLevel(juego);}
						break;
					case 10:
						 if(solucion.getText().toString().toLowerCase().equals("ojo")){
							 nextLevel(juego);}
						break;
					default:
					{
						juego.putExtra("lvl",lvl);
						juego.putExtra("color", Color.BLACK);
						startActivity(juego);
						finish();
						break;
					}
					
				}		
				
				
			}

			private void nextLevel(final Intent juego) {
			     juego.putExtra("lvl",lvl);
				 juego.putExtra("color",color);
				 startActivity(juego);
				 finish();
			}
		});
		
		
		repetir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				juego.putExtra("lvl",lvl--);
				juego.putExtra("color", Color.BLACK);
				startActivity(juego);
				finish();
				
				}
			});
		
		
		salir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final MusicaSingleton musica=MusicaSingleton.getInstance();
							musica.destroyMusic();
							finish();
											
				}
			});

	}	
	
	

}

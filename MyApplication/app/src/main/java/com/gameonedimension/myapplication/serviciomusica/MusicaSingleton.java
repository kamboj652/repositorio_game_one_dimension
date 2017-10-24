package com.gameonedimension.myapplication.serviciomusica;

import android.content.Context;
import android.media.MediaPlayer;


public class MusicaSingleton {
	
	MediaPlayer musica;
	
	private static MusicaSingleton INSTANCE = new MusicaSingleton();
	 
    // El constructor privado no permite que se genere un constructor por defecto
    // (con mismo modificador de acceso que la definici�n de la clase) 
    private  MusicaSingleton() {
		// TODO Auto-generated constructor stub
	}
 
    public static MusicaSingleton getInstance() {
        return INSTANCE;
    }
    
    public void setMusic(int m, Context c){
    	musica = MediaPlayer.create(c, m);    	
    }
    
    public void playMusic(){    	
    	musica.start();
    	musica.setLooping(true);
    }
    
    public void stopMusic(){
    	musica.stop();
    }
    
    public void destroyMusic(){
    	stopMusic();
    	INSTANCE=null;
    }
    
}







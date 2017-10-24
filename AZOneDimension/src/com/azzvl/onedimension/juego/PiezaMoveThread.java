package com.azzvl.onedimension.juego;


public class PiezaMoveThread extends Thread {

	private Pieza bola;
	private boolean run;
	
	
	public PiezaMoveThread(Pieza bola) {
		this.bola = bola;
		this.run = false;
	}
	
	public void setRunning(boolean run) {
		this.run = run;
	}
	
	@Override
	public void run() {
		while(run) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bola.move();
			
		}
		
	}
}

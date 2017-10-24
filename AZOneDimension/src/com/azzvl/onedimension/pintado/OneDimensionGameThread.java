package com.azzvl.onedimension.pintado;

import android.graphics.Canvas;
import android.view.SurfaceHolder;


public class OneDimensionGameThread extends Thread {

	private SurfaceHolder sh;
	private LienzoGameView view;
	private boolean run;
	
	public OneDimensionGameThread(SurfaceHolder sh, LienzoGameView view) {
		this.sh = sh;
		this.view = view;
		run = false;
	}

	public void setRunning(boolean run) {
		this.run = run;
	}
	
	public void run() {
		Canvas canvas;
		while(run) {
			canvas = null;
			try {
				canvas = sh.lockCanvas(null);
				synchronized(sh) {
					view.onDraw(canvas);
				}
			} finally {
				if(canvas != null)
					sh.unlockCanvasAndPost(canvas);
			}
		}
		
	}
}

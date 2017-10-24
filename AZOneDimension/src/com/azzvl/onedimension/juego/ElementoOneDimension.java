package com.azzvl.onedimension.juego;

import android.graphics.Rect;
import android.graphics.Bitmap;

public abstract class ElementoOneDimension {

	protected Coordenada origen;
	protected int ancho;
	protected int alto;
	protected Bitmap imagen;
	
	public ElementoOneDimension(Coordenada origen, int ancho, int alto, Bitmap imagen) {
		this.origen = origen;
		this.ancho = ancho;
		this.alto = alto;
		this.imagen = imagen;
	}
	
	public int getOrigenX() {
		return origen.getX();
	}
	
	public int getOrigenY() {
		return origen.getY();
	}
	
	public void setOrigenX(int newX) {
		origen.setX(newX);
	}
	
	public void setOrigenY(int newY) {
		origen.setY(newY);
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}	
	
	public boolean puedoMover(int x, int y, Rect screen) {
		return screen.contains(origen.getX() + x, origen.getY() + y,
				origen.getX() + ancho + x, origen.getY() + alto + y);
	}
}

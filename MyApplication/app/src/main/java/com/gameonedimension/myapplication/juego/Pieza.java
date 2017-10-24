package com.gameonedimension.myapplication.juego;

import android.graphics.Bitmap;

public class Pieza extends ElementoOneDimension implements ElementoMovil {


    public Pieza(Coordenada origen, int ancho, int alto, Bitmap imagen) {
        super(origen, ancho, alto, imagen);

    }

    @Override
    public void move() {
        //descenso de la pieza
        origen.setX(origen.getX() + 1);

    }
}

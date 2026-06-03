package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class castillo {

    Image imagenCastillo;
    double castilloX = 3700;
    double castilloY = 350;
    
    int ancho = 10;
    int alto = 300;
    
    boolean gano = false;

    public castillo() {
        imagenCastillo = Herramientas.cargarImagen("castillo.png");
    }

    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(imagenCastillo, castilloX, castilloY, 0, 0.5);
    }

    public void mover(double velocidadScroll) {
        castilloX += velocidadScroll;
    }

    public boolean tocarCastillo(personaje p) {
  
        double castIzq = castilloX - ancho / 3;
        double castDer = castilloX + ancho / 2;
        double castArriba = castilloY - alto / 2;
        double castAbajo = castilloY + alto ;

        
        int pjIzq = p.x - 25;
        int pjDer = p.x + 45;
        int pjArriba = p.y - 20;
        int pjAbajo = p.y + 60;

    
        return !(pjDer < castIzq || pjIzq > castDer || 
                 pjAbajo < castArriba || pjArriba > castAbajo);
    }


    public boolean gano() {
        return gano;
    }

    public void setGano(boolean valor) {
        this.gano = valor;
    }
}
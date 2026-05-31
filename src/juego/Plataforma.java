package juego;

import java.awt.Color;
import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;
public class Plataforma {
	
	
    private double x;
    private double y;

    private int ancho;
    private int alto;
    Image imagenplataforma;
    
 
    public Plataforma(double x, double y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagenplataforma = Herramientas.cargarImagen("rama.png");
    }

    public void dibujar(Entorno entorno) {

       entorno.dibujarImagen(imagenplataforma, this.x, this.y+20, 0, 0.2);
        
    }
    


    public void mover(double dx) {
        x += dx;
    }

    public double izquierda() {
        return x - ancho / 2;
    }

    public double derecha() {
        return x + ancho / 2;
    }

    public double arriba() {  
        return y - alto / 2;
    }

    public double abajo() {
        return y + alto / 2;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public boolean estaApoyada(Plataforma[] plataformas, Plataforma[] piso) {
        
        for (int i = 0; i < plataformas.length; i++) {
            if (plataformas[i] != null && chocaCon(plataformas[i])) {
                this.y = (int)plataformas[i].arriba() - 20;
                return true;
            }
        }
       
        for (int i = 0; i < piso.length; i++) {
            if (piso[i] != null && chocaCon(piso[i])) {
                this.y = (int)piso[i].arriba() - 20;
                return true;
            }
        }
        return false;
    }

  
    private boolean chocaCon(Plataforma p) {
        return (this.x > p.izquierda() && this.x < p.derecha() &&
                this.y + 20 >= p.arriba() && this.y + 20 <= p.arriba() + 10);
    }
}
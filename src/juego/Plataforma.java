package juego;

import java.awt.Color;
import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;
public class Plataforma {
	
	
    double x;
    double y;

    int ancho;
    int alto;
    Image imagenplataforma;
   
   
 
    public Plataforma(double x, double y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }
    public void dibujarultima(Entorno entorno) {
    	if (ancho == 600) {
    		imagenplataforma = Herramientas.cargarImagen("larga.png");
    		entorno.dibujarImagen(imagenplataforma, x, y, 0, 0.5);
    	}
    }

    public void dibujar(Entorno entorno) {
        if (ancho == 120) {
            imagenplataforma = Herramientas.cargarImagen("corta.png");
            entorno.dibujarImagen(imagenplataforma, x, y, 0, 0.2);
        } else if (ancho == 160) {
            imagenplataforma = Herramientas.cargarImagen("mediana.png");
            entorno.dibujarImagen(imagenplataforma, x, y, 0, 0.2);
        } else if (ancho == 200) {
            imagenplataforma = Herramientas.cargarImagen("larga.png");
            entorno.dibujarImagen(imagenplataforma, x, y, 0, 0.2);
        } else if (ancho == 600) {
            imagenplataforma = Herramientas.cargarImagen("larga.png");
            entorno.dibujarImagen(imagenplataforma, x, y, 0, 0.5);
        }
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
   
 
}
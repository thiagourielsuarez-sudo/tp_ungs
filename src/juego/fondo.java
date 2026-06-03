package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import java.awt.Image;

public class fondo {

	int x = 900;
	int y = 300;
	double escala =0.6;
	double velocidad = -0.01;
	Image imagenfondo;
	castillo g = new castillo();
	public void movimientofondo(Entorno entorno) {
	    
	    if (!g.gano()) {
	        if (entorno.estaPresionada('d')) {
	            x += velocidad;
	        }
	    }
	}
}

package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import java.awt.Image;

public class fondo {

	int x = 900;
	int y = 300;
	double escala =0.599;
	double velocidad = -0.1;
	Image imagenfondo;
	public void movimientofondo (Entorno entorno) {
		imagenfondo = Herramientas.cargarImagen("fondoF.png");
		if (entorno.estaPresionada('d')) {
			x+= velocidad;
		}
			
	}
			
}

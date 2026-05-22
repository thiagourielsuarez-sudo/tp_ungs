package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import java.awt.Image;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Image imagenfondo;
	personaje p = new personaje();
	fondo f = new fondo();
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		imagenfondo = Herramientas.cargarImagen("fondoF.png");
		
		
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		f.movimientofondo(entorno);
		this.entorno.dibujarImagen(imagenfondo,f.x, f.y , 0, f.escala);
		
		
		p.Movimiento(entorno);
		p.Fotogramader(entorno);
		p.Fotogramaizq(entorno);
		p.limite(entorno);
		if (p.ultimadireccion.equals("derecha")) {
			this.entorno.dibujarImagen(p.Fotos[p.i], p.x, p.y, 0, 0.4);
		}else {
			this.entorno.dibujarImagen(p.imagenes[p.k], p.x, p.y, 0, 0.4);
		}
		
		
		
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}

package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import java.awt.Image;

public class Juego extends InterfaceJuego
{

	private Entorno entorno;  
	private Plataforma[] piso;
	private Plataforma[] plataformas;
	Image imagenfondo;
	personaje p = new personaje();
	fondo f = new fondo();
		
	public Juego() {
        imagenfondo = Herramientas.cargarImagen("fondoF.png");
     
        piso = new Plataforma[6];
        int xInicial = 150;
        for (int i = 0; i < piso.length; i++) {
            piso[i] = new Plataforma(xInicial, 520, 180, 40);
            int distanciaAleatoria = 220 + (int)(Math.random() * 150);
            xInicial += distanciaAleatoria;
        }
      
        plataformas = new Plataforma[8];
        for (int i = 0; i < plataformas.length; i++) {
            int x = 400 + i * 300; 
            int y = (Math.random() < 0.5) ? 350 : 200;
            plataformas[i] = new Plataforma(x, y, 140, 30);
        }             
        this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
        this.entorno.iniciar();
    }

	public void tick() {
        this.entorno.dibujarImagen(imagenfondo, f.x, f.y, 0, f.escala);
    
        double velocidadScroll = 0;
        if (entorno.estaPresionada('d')) {
            velocidadScroll = -2.0; 
            f.movimientofondo(entorno); 
        }

        // Lógica de plataformas y piso con scroll
        for (int i = 0; i < piso.length; i++) {
            if (piso[i] != null) {
                piso[i].mover(velocidadScroll);
                piso[i].dibujar(entorno);
                if (piso[i].derecha() < 0) {
                    piso[i] = new Plataforma(800 + 100, 520, 180, 40);
                }
            }
        } 

        for (int i = 0; i < plataformas.length; i++) {
            if (plataformas[i] != null) {
                plataformas[i].mover(velocidadScroll);
                plataformas[i].dibujar(entorno);
                if (plataformas[i].derecha() < 0) {
                    double nuevaX = 800 + 200;
                    int nuevaY = (Math.random() < 0.5) ? 350 : 200;
                    plataformas[i] = new Plataforma(nuevaX, nuevaY, 140, 30);
                }
            }
        } 
      
        // AQUÍ ESTÁ EL CAMBIO CLAVE:
        // Pasamos los arreglos al personaje para que detecte colisiones
        p.Movimiento(entorno, plataformas, piso);
        p.Fotogramader(entorno);
        p.Fotogramaizq(entorno);
        p.limite(entorno);
        
        // Dibujo
        if (p.ultimadireccion.equals("derecha")) {
            this.entorno.dibujarImagen(p.Fotos[p.i], p.x, p.y, 0, 0.4);
        } else {
            this.entorno.dibujarImagen(p.imagenes[p.k], p.x, p.y, 0, 0.4);
        }
    }
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}

}

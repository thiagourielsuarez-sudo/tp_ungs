package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import java.awt.Image;

public class Juego extends InterfaceJuego
{

	private Entorno entorno;  
	private Plataforma[] plataformas;
	private Enemigo[] enemigos;
	Image imagenfondo;
	personaje p = new personaje();
	fondo f = new fondo();
	castillo c = new castillo();
	private Bala bala;
	
		
	public Juego() {
		
		enemigos = new Enemigo[20];
		
        imagenfondo = Herramientas.cargarImagen("fondoF.png");
     
        int[] alturas = {200, 350, 500};
        int[]anchos = {120,160,200};
        plataformas = new Plataforma[30];
        plataformas[0] = new Plataforma(400, 300, 160, 30);
        plataformas [1] = new Plataforma(3700, 600, 600, 40);
        for (int i = 2; i < plataformas.length; i++) {
            int x = 400 + i * 100; 
            int y = alturas[(int)(Math.random() * alturas.length)];
            int anchopla = anchos[(int)(Math.random() * anchos.length)];
            plataformas[i] = new Plataforma(x, y, anchopla, 30);
            
        }             
        this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
        this.entorno.iniciar();
        bala = null;
    }
	
	private void generarEnemigo() {
		 int[] alturas = {150, 300, 450};
	    for (int i = 0; i < enemigos.length; i++) {

	        if (enemigos[i] == null) {
	        	int yy =	alturas[(int)(Math.random() * alturas.length)];
	            if (Math.random() < 0.5) {
	                enemigos[i] = new Enemigo( -20, yy ,2);

	            } else {enemigos[i] = new Enemigo(820, yy ,-2);
	            }

	            return;
	        }
	    }
	}

	public void tick() {
		if (p.getVida() <= 0) {
			entorno.cambiarFont("Arial", 80, Color.RED);
	        entorno.escribirTexto("PERDISTE", 220, 250);
		}
		
		int vivos = 0;
	

		for (int i = 0; i < enemigos.length; i++) {

		    if (enemigos[i] != null) {
		        vivos++;
		    }
		}

		while (vivos < 6) {
		    generarEnemigo();
		    vivos++;
		}
        this.entorno.dibujarImagen(imagenfondo, f.x, f.y, 0, f.escala);
    
        double velocidadScroll = 0;
        if (!c.gano && entorno.estaPresionada('d')) {
            velocidadScroll = -3.0; 
            f.movimientofondo(entorno); 
        }

      
        int[] alturas = {200, 350, 500};
        int[]ancho = {120,160,200};
        for (int i = 0; i < plataformas.length; i++) {
            if (plataformas[i] != null) {
                plataformas[i].mover(velocidadScroll);
                plataformas[i].dibujar(entorno);
                if (plataformas[i].derecha() < 0) {
                    plataformas[i] = null;
                }
            }
        } 
        for (int i = 0; i < enemigos.length; i++) {

            if (enemigos[i] != null) {

                enemigos[i].mover();

                if (entorno.estaPresionada('d')) {
                    enemigos[i].moverConScroll(-2.0);
                }

                enemigos[i].dibujar(entorno);

                if (enemigos[i].colisiona(p)) {
                    p.recibirDanio(1);
                    enemigos[i] = null;
                }

                if (enemigos[i] != null && enemigos[i].fueraDePantalla()) {
                    enemigos[i] = null;
                }
            }
        }
        
        c.mover(velocidadScroll);
        c.dibujar(entorno);

       
        if (c.tocarCastillo(p) && !c.gano()) {
            c.setGano(true);
        }

       
        if (c.gano()) {
            velocidadScroll = 0;
            p.velocidad=0;
            
          
            entorno.cambiarFont("Arial", 100, Color.YELLOW);
            entorno.escribirTexto("¡GANASTE!", 150, 200);
        }

        p.Movimiento(entorno, plataformas);
        p.Fotogramader(entorno);
        p.Fotogramaizq(entorno);
        p.limite(entorno);
     
        if (p.ultimadireccion.equals("derecha")) {
            this.entorno.dibujarImagen(p.Fotos[p.i], p.x, p.y, 0, 0.4);
        } else {
            this.entorno.dibujarImagen(p.imagenes[p.k], p.x, p.y, 0, 0.4);
        }
        entorno.cambiarFont("Arial", 20, Color.BLACK);
        entorno.escribirTexto("Vida: " + p.getVida(), 20, 30);

        if (entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && bala == null) {
            disparar();
        }
       
        if (bala != null) {
            bala.mover();
            bala.dibujar(entorno);
           
            boolean impacto = false;
            for (int i = 0; i < enemigos.length; i++) {
                if (enemigos[i] != null && bala.colisiona(enemigos[i])) {
                    enemigos[i] = null;
                    impacto = true;
                    break;
                }
            }
           
            if (impacto || bala.fueraDePantalla()) {
                bala = null;
            }
        }

        if (p.getVida() <= 0) {
            p.velocidad = 0;
            velocidadScroll = 0;
            
            entorno.cambiarFont("Arial", 80, Color.RED);
            entorno.escribirTexto("PERDISTE", 220, 250);
            return;
        }
    }

    private void disparar() {
        double dx = entorno.mouseX() - p.x;
        double dy = entorno.mouseY() - p.y;
        double angulo = Math.atan2(dy, dx);
       
        double distancia = 30;
        double balaX = p.x + Math.cos(angulo) * distancia;
        double balaY = p.y + Math.sin(angulo) * distancia - 10;
       
        bala = new Bala(balaX, balaY, angulo);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        Juego juego = new Juego();
    }
}
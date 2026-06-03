package juego;

import java.awt.Color;
import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;

public class personaje {
	
	int x = 400;
	int y = 100;
	int velocidad = 3;
	int vida = 8;
	Image foto1 = Herramientas.cargarImagen("foto1.png");
	Image foto2 = Herramientas.cargarImagen("foto2.png");
	Image foto3 = Herramientas.cargarImagen("foto3.png");
	Image foto4 = Herramientas.cargarImagen("foto4.png");
	Image foto5 = Herramientas.cargarImagen("foto5.png");
	Image foto6 = Herramientas.cargarImagen("foto6.png"); 
	Image foto7 = Herramientas.cargarImagen("foto7.png");
	Image foto8 = Herramientas.cargarImagen("foto8.png");
	Image foto9 = Herramientas.cargarImagen("foto9.png");   
	
	Image imagen1 = Herramientas.cargarImagen("image1.png");
	Image imagen2 = Herramientas.cargarImagen("image2.png");
	Image imagen3 = Herramientas.cargarImagen("image3.png");
	Image imagen4 = Herramientas.cargarImagen("image4.png");
	Image imagen5 = Herramientas.cargarImagen("image5.png");
	Image imagen6 = Herramientas.cargarImagen("image6.png"); 
	Image imagen7 = Herramientas.cargarImagen("image7.png");
	Image imagen8 = Herramientas.cargarImagen("image8.png");
	Image imagen9 = Herramientas.cargarImagen("image9.png");   
	
	Image [] imagenes = {imagen1, imagen2, imagen3, imagen4, imagen5, imagen6, imagen7, imagen8, imagen9};
	Image [] Fotos  =  {foto1, foto2, foto3, foto4, foto5, foto6, foto7, foto8, foto9,}; 
	String ultimadireccion = "derecha";
	int contadorticks = 0;
	int contadortick = 0;
	int i = 0;
	int k = 0;
	double velocidadY;
	castillo g = new castillo();
	
	public void Movimiento(Entorno entorno, Plataforma[] plataformas) {  

	    if (vida <= 0) {
	        return;
	    }

			for (int j = 0; j < plataformas.length; j++) {

		    if (plataformas[j] != null) {

		        if (entorno.estaPresionada('d') && chocaIzquierda(plataformas[j])) {
		            x = (int) plataformas[j].izquierda() - 15;
		        }

		        if (entorno.estaPresionada('a') && chocaDerecha(plataformas[j])) {
		            x = (int) plataformas[j].derecha() + 15;
		        }
		    }
		}

	
		if (!g.gano && entorno.estaPresionada('d') && x < 700) {
		    x += velocidad;
		    ultimadireccion = "derecha";
		}
	    if (entorno.estaPresionada('a')) { x -= velocidad; ultimadireccion = "izquierda"; }    
	    
	  
	    if (estaApoyada(plataformas)) {
	    
	        velocidadY = 0; 
	        
	      
	    if (entorno.sePresiono('w')) {
	            velocidadY = -8;
	        }
	    } else {
	        
	        velocidadY += 0.2; 
	    }		if (velocidadY >8)
	    			velocidadY = 8;
	    
	   
	    y += velocidadY;
	}

	public void Fotogramader (Entorno entorno) {
		if ((entorno.estaPresionada('d')) == true) {
			contadorticks +=1;
			if (contadorticks == 8)    {
				i+=1; contadorticks = 0;
				if (i >= Fotos.length-1)   { i = 0 ; }
			}
		} else {
			if (entorno.estaPresionada('a')== false) {
				contadorticks = 0;   
				if (ultimadireccion.equals("derecha")) { i = 8; }   
			}
		}		
	}			

	public void Fotogramaizq (Entorno entorno) {
		if ((entorno.estaPresionada('a')) == true) {
			contadortick +=1;
			if (contadortick == 8)    {
				k+=1; contadortick = 0;
				if (k >= imagenes.length-1)   { k = 0 ; }
			}
		} else {
			if (entorno.estaPresionada('d')==false) {
				contadortick = 0;
				if (ultimadireccion.equals("izquierda")) { k = 8; }		
			}						
		}
	}

	public void limite (Entorno entorno) {
	    if (x > 700) x = 700;
	    if (x < 20) x = 20;
	    
	    if (y > 550) {
	        recibirDanio(1);
	        y = 50;
	    }
	    
	    if (y < 50) y = 50;
	}
	
	public boolean estaApoyada (Plataforma[] plataformas) {

	    for (int j = 0; j < plataformas.length; j++) {

	        if (plataformas[j] != null) {

	            if (chocaArriba(plataformas[j])) {
	                y = (int) plataformas[j].arriba() - 35;
	                velocidadY = 0;
	                return true;
	            }

	            if (chocaAbajo(plataformas[j])) {
	                y = (int) plataformas[j].abajo() + 35;
	                velocidadY = 0;
	            }
	        }
	    }
	 return false;
	}
	private boolean chocaArriba(Plataforma p) {
	    return (
	        this.x > p.izquierda() &&
	        this.x < p.derecha() &&
	        this.y + 35 >= p.arriba() &&
	        this.y + 35 <= p.arriba() + 10 &&
	        velocidadY >= 0
	    );
	}

	private boolean chocaAbajo(Plataforma p) {
	    return (
	        this.x > p.izquierda() &&
	        this.x < p.derecha() &&
	        this.y - 35 <= p.abajo() &&
	        this.y - 35 >= p.abajo() - 10 &&
	        velocidadY < 0
	    );
	}
	private boolean chocaIzquierda(Plataforma p) {
	    return (
	        this.x + 15 >= p.izquierda() &&
	        this.x < p.izquierda() &&
	        this.y + 30 > p.arriba() &&
	        this.y - 30 < p.abajo()
	    );
	}

	private boolean chocaDerecha(Plataforma p) {
	    return (
	        this.x - 15 <= p.derecha() &&
	        this.x > p.derecha() &&
	        this.y + 30 > p.arriba() &&
	        this.y - 30 < p.abajo()
	    );
	}
	
	
	
	public void recibirDanio(int cantidad) {
		this.vida -= cantidad;
	}
	
	public int getVida() {
		return this.vida;
	}
	
} 
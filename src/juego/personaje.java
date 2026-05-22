package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;





public class personaje {
	
	int x = 100;
	int y = 100;
	int velocidad = 2;
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
	String ultimadireccion = "derechada";
	int contadorticks = 0;
	int contadortick = 0;
	int i = 0;
	int k = 0;
	
	public void Movimiento (Entorno entorno) {  
		
		if ((entorno.estaPresionada('d')) == true) {
			x= x +velocidad; ultimadireccion = "derecha";
		}	
		
		if ((entorno.estaPresionada('a')) == true)	{
			x= x - velocidad; ultimadireccion = "izquierda";
		}	
		if ((entorno.estaPresionada('w')) == true)	{
			y= y - velocidad;
		}
		if ((entorno.estaPresionada('s')) == true)	{
			y= y + velocidad;
		
		}
	
	}
	public void Fotogramader (Entorno entorno) {
		     
		if ((entorno.estaPresionada('d')) == true) {
			contadorticks +=1;
			if (contadorticks == 8)    {
				i+=1; contadorticks = 0;
				if (i >= Fotos.length-1)   {
					i = 0 ;
		
				}
			}
		}
		else{
			if (entorno.estaPresionada('a')== false) {
				contadorticks = 0;   
				if (ultimadireccion.equals("derecha")) {
					i = 8;
				}   
			}
		}		
	}			
	public void Fotogramaizq (Entorno entorno) {
			
		if ((entorno.estaPresionada('a')) == true) {
			contadortick +=1;
			if (contadortick == 8)    {
				k+=1; contadortick = 0;
				if (k >= imagenes.length-1)   {
					k = 0 ;
				}
			}
		}	
		
		else{
			if (entorno.estaPresionada('d')==false) {
				contadortick = 0;
				if (ultimadireccion.equals("izquierda")) {
					k = 8;
				}		
			}						
		}
	}
	public void limite (Entorno entorno) {
		if (x >780) {
			x = 780;	
		}
	
		if (x < 20) {
			x = 20;	
		}
		if (y > 550) {
			y= 50;
		}
		if (y < 50) {
			y = 50;
		}
	}

	
	
	
	
	
	
}
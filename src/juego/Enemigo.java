package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Enemigo {

    private double x;
    private double y;
    private double velocidad;
    private int vida;

    private Image imagen;

    public Enemigo(double x, double y, double velocidad) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.vida = 1;

        if (velocidad > 0) {
            imagen = Herramientas.cargarImagen("enemigoder.png");
        } else {
            imagen = Herramientas.cargarImagen("enemigoizq.png");
        }
    }

    public void mover() {
        x += velocidad;
    }

    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(imagen, x, y, 0, 0.04);
    }

    public boolean fueraDePantalla() {
        return x < -50 || x > 850;
    }

    public boolean colisiona(personaje p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy) < 40;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void moverConScroll(double velocidadScroll) {
        this.x += velocidadScroll;
    }
    public void recibirDanio(int cantidad) {
        this.vida -= cantidad;
    }

    public boolean estaMuerto() {
        return this.vida <= 0;
    }
}
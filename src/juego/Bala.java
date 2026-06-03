package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Bala {

    private double x;
    private double y;
    private double velocidad;
    private double angulo;
    private Image imagen;

    public Bala(double x, double y, double angulo) {
        this.x = x;
        this.y = y;
        this.angulo = angulo;
        this.velocidad = 5.0;

        this.imagen = Herramientas.cargarImagen("bala.png");
    }

    public void mover() {
        x += Math.cos(angulo) * velocidad;
        y += Math.sin(angulo) * velocidad;
    }

    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(imagen, x, y, angulo, 0.1);
    }

    public boolean colisiona(Enemigo e) {
        if (e == null) return false;
        double dx = x - e.getX();
        double dy = y - e.getY();
        return (dx * dx + dy * dy) < 800;
    }

    public boolean fueraDePantalla() {
        return x < -50 || x > 850 || y < -50 || y > 650;
    }
}
package com.juego.modelo;
import com.juego.modelo.Personaje;
public class Combate {
    Personaje p1;
    Personaje p2;
    public Combate(Personaje p1, Personaje p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public void iniciar(){
        int cont = 0;
        while (this.p1.getVida()>0 && this.p2.getVida()>0){
            System.out.println("| Ronda" + cont + " |");
           ;
            System.out.println("| Datos: |");
            System.out.println("| Personaje 1 | " + p1.mostrarDatos());
            System.out.println("| Personaje 2 | " + p1.mostrarDatos());
            cont++;
        }
    }
}

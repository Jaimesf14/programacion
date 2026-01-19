package com.juego.razas;

import com.juego.modelo.Personaje;

public interface Raza {
    String getNombre();
    int getFuerza();
    int getInteligencia();
    int getDestreza();
    int getVidaBase();
    String getEspecialidad();

}
 /*   void bonificadorRaza(Personaje p);
}
    //se pone que la clase es abstract ya que los atributos no se van a modificar en esta clase, y además, sirve como
    //plantilla para las subclases.
    protected String nombre;
    protected int fuerza;
    protected int inteligencia;
    protected int destreza;
    protected int vidaBase;
    protected String especialidad;
    //ponemos protected ya que si lo ponemos private no lo podemos modificar en las subclases.

    //contructor
    public Raza(String nombre, int fuerza, int inteligencia, int destreza, int vidaBase, String especialidad){
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.destreza = destreza;
        this.vidaBase = vidaBase;
        this.especialidad = especialidad;
    }
*/


package com.juego.razas;

public abstract class raza {
    //se pone que la clase es abstract ya que los atributos no se van a modificar en esta clase, y además, sirve como
    //plantilla para las subclases.
    protected String nombre;
    protected int fuerza;
    protected int inteligencia;
    protected int destreza;
    protected int vidaBase;
    protected String especialidad;
    //ponemos protected ya que si lo ponemos private no lo podemos modificar en las subclases.

    //Metodos get
    public String getNombre() {
        return nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

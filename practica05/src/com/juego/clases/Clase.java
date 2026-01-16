package com.juego.clases;

public interface Clase {
    /*//se pone que la clase es abstract ya que los atributos no se van a modificar en esta clase, y además, sirve como
    //plantilla para las subclases.
    protected int bonificacionFuerza;
    protected int bonificacionInteligencia;
    protected int bonificacionDestreza;
    protected int vidaMax;
    //ponemos protected ya que si lo ponemos private no lo podemos modificar en las subclases.

    //contructor
    public Clase(int bonificacionFuerza, int bonificacionInteligencia, int bonificacionDestreza, int vidaMax) {
        this.bonificacionFuerza = bonificacionFuerza;
        this.bonificacionInteligencia = bonificacionInteligencia;
        this.bonificacionDestreza = bonificacionDestreza;
        this.vidaMax = vidaMax;
    }
    //metodos get

    public int getBonificacionFuerza() {
        return bonificacionFuerza;
    }

    public int getBonificacionInteligencia() {
        return bonificacionInteligencia;
    }

    public int getBonificacionDestreza() {
        return bonificacionDestreza;
    }

    public int getVidaMax() {
        return vidaMax;
    }*/
    String getNombre();
    int getBonificacionFuerza();
    int getBonificacionInteligencia();
    int getBonificacionDestreza();
    int getVidaMax();

}

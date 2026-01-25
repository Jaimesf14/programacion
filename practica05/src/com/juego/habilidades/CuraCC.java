package com.juego.habilidades;

public class CuraCC implements Habilidades{
    private int usos = 3;
    private int usosRestantes;
    private String nombre;
    private String definicion;
    private int bonificador;

    //Constructor
    public CuraCC(String nombre, String definicion, int bonificador, int usos){

        this.nombre = nombre;
        this.definicion = definicion;
        this.bonificador = bonificador;
        this.usos = usos;
    }
    @Override
    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public String definicion() {
        return definicion;
    }

    @Override
    public int bonificador() {
        return bonificador;
    }

    //El dos significa que es de cura
    @Override
    public int getTipo() {
        return 2;
    }

    @Override
    public void restarUsos() {
        if (this.usos>0){
            this.usos--;
        }

    }
}
//Metodods Get y Set

    /*public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public int getBonificador() {
        return bonificador;
    }

    public void setBonificador(int bonificador) {
        this.bonificador = bonificador;
    }

   /* //Informacion
    public void informacion(){
        System.out.println("Nombre habilidad: " + nombre);
        System.out.println("Descripción: " + definicion);
        System.out.println("Usos maximos: " + usos);
        System.out.println("Usos actuales: " + usosRestantes);
        System.out.println("Daño que provoca: " + bonificador);
    }*/

    //Metodos interfaz



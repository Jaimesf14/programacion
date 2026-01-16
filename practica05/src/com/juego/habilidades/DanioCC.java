package com.juego.habilidades;

public class DanioCC implements Habilidades{
    private int usos = 5;
    private int usosRestantes;
    private String nombre;
    private String definicion;
    private int bonificador;

    //Constructor
    public DanioCC(String nombre, String definicion, int bonificador){

        this.nombre = nombre;
        this.definicion = definicion;
        this.bonificador = bonificador;
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

    @Override
    public int usos() {
        return usos;
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
}


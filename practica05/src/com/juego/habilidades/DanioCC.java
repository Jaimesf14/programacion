package com.juego.habilidades;

public class DanioCC implements Habilidades{
    private int usos = 5;
    private int usosRestantes;
    private String nombre;
    private String definicion;
    private int bonificador;

    //Constructor
    public DanioCC(String nombre, String definicion, int bonificador, int usos){

        this.nombre = nombre;
        this.definicion = definicion;
        this.bonificador = bonificador;
        this.usos = usos;
    }
    //get Y set

    public int getBonificador() {
        return bonificador;
    }

    public void setBonificador(int bonificador) {
        this.bonificador = bonificador;
    }


    @Override
    public int getUsos() {
        return 5;
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

    //El uno significa que es de danio
    @Override
    public int getTipo() {
        return 1;
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




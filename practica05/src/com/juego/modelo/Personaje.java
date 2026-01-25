package com.juego.modelo;

import com.juego.clases.Clase;
import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioDistancia;
import com.juego.habilidades.Habilidades;
import com.juego.razas.Raza;

import java.util.ArrayList;

public class Personaje {
    //atributos
    private String nombre;
    private int fuerza;
    private int destreza;
    private int inteligencia;
    private int vida;
    ArrayList<Habilidades> habilidades;
    Raza raza;
    Clase clase;

    //constructor
    public Personaje(String nombre, Raza raza, Clase clase, ArrayList<Habilidades> habilidades){
        this.nombre = nombre;
        this.raza = raza;
        this.clase = clase;
        this.habilidades = habilidades;
        this.fuerza = raza.getFuerza() + clase.getBonificacionFuerza(); ;
        this.destreza = raza.getDestreza() + clase.getBonificacionDestreza();
        this.inteligencia = raza.getInteligencia() + clase.getBonificacionInteligencia();
        this.vida = raza.getVidaBase() + clase.getVidaMax();
    }


    public void recibirDanio(DanioCC danioCC, DanioDistancia danioDistancia, Habilidades habilidades){
        if (habilidades == danioCC || habilidades == danioDistancia){
            vida -= habilidades.bonificador();
        }
    }

    public void recibirCuracion(CuraCC curaCC, Habilidades habilidades){
        if (habilidades == curaCC){
            vida += habilidades.bonificador();
        }
    }


    //Para recorrer la lista de habilidades de cada personaje.
    public ArrayList<Habilidades> getHabilidades(){
        return habilidades;
    }

    //Metodos getter para mostrat informacion
    public String getNombre() {
        return nombre;
    }

    public int getVida(){
        return vida;
    }

    public String mostrarDatos(){
        return "Nombre: " + nombre + " | Vida: " + vida + " | Raza: " + raza.getNombre() + " | Clase: " + clase.getNombre();
    }
    //metodos set

    public void setVida(int vida) {
        this.vida = vida;
    }
}

/*
    //get y set


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getFuerza() {
        return fuerza;
    }


    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }


    public int getDestreza() {
        return destreza;
    }


    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }


    public int getInteligencia() {
        return inteligencia;
    }


    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }


    public int getVidaBase() {
        return vidaBase;
    }


    public void setVidaBase(int vidaBase) {
        this.vidaBase = vidaBase;
    }


    public String getEspecialidad() {
        return especialidad;
    }


    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    public int getVidaMax() {
        return vidaMax;
    }


    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }
}

    //atributo de los personajes
    private String nombre;
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vida;
}*/

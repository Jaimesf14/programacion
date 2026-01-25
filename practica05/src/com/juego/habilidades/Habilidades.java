package com.juego.habilidades;

import com.juego.modelo.Personaje;

public interface Habilidades {
    int getUsos();
    void setUsos(int usos);
    String nombre();
    String definicion();
    //los puntos que quita la habilidad
    int bonificador();
    //para saber si es una habilidad de cura o danio
    int getTipo();

    void restarUsos();
}


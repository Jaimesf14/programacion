package com.juego.habilidades;

public class Explosion implements Habilidades {
    private int usos = 1;
    private String nombre = "Explosion";
    private String definicion = "Una explosion que daña al enemigo, pero tambien al atacante levemente.";
    private int bonificador = 40;

    @Override
    public int getUsos() {
        return usos;
    }

    @Override
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

    @Override
    public int getTipo() {
        // 1 es daño
        return 1;
    }

    @Override
    public void restarUsos() {
        if (this.usos>0){
            this.usos--;
        }
    }
}


package com.juego.modelo;
import com.juego.habilidades.Habilidades;
import com.juego.modelo.Personaje;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Combate {
    private Personaje p1;
    private Personaje p2;
    private Scanner s = new Scanner(System.in);

    public Combate(Personaje p1, Personaje p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public void iniciar(){
        int cont = 0;

        //Mientras los dos jugadores tengan vida continua la partida
        int turno = 1;
        while (this.p1.getVida()>0 && this.p2.getVida()>0){

            //Datos de la ronda
            System.out.println("---------------------------------------------------------");
            System.out.println("| Ronda" + cont + " |");
           ;
            System.out.println("| Datos: |");
            System.out.println("| Personaje 1 | " + p1.mostrarDatos());
            System.out.println("| Personaje 2 | " + p2.mostrarDatos());
            cont++;


            Personaje atacante;
            Personaje defensor;

            if (turno == 1){
                atacante = p1;
                defensor = p2;
            } else{
                atacante = p2;
                defensor = p1;
            }

            System.out.println("| Turno de " + atacante.getNombre() +" de atacar.");

            //Elegir habilidades
            System.out.println("| Elige una habilidad: |");
            Habilidades h1 = atacante.getHabilidades().get(0);
            Habilidades h2 = atacante.getHabilidades().get(1);
            Habilidades h3 = atacante.getHabilidades().get(2);

            System.out.println("| 1. " + h1.nombre() + " | Daño: " + h1.bonificador() + " | Usos: " + h1.getUsos() + " | " + h1.definicion());
            System.out.println("| 2. " + h2.nombre() + " | Cura: " + h2.bonificador() + " | Usos: " + h2.getUsos() + " | " + h2.definicion());
            System.out.println("| 3. " + h3.nombre() + " | Daño: " + h3.bonificador() + " | Usos: " + h3.getUsos() + " | " + h3.definicion());
            int eleccion = s.nextInt();
            int numero = eleccion - 1;
            //al empezar el arrayList por 0, le tenemos que resta 1 a la opcion elegida para que coincida.

            //seleccionar la habilidad elegida
            Habilidades hElegida = atacante.getHabilidades().get(numero);

            if (hElegida.getUsos() > 0) {

            //Aplicar danio
            if (hElegida.getTipo() == 1){
                int vidaBaja = defensor.getVida() - hElegida.bonificador();
                defensor.setVida(vidaBaja);
                System.out.println("| " + atacante.getNombre() + " usa la habilidad " + hElegida.nombre() + " contra " + defensor.getNombre() + ".");

            //Aplicar cura
            } else{
                int vidaSube = atacante.getVida() + hElegida.bonificador();
                atacante.setVida(vidaSube);
                System.out.println("| " + atacante.getNombre() + " usa la habilidad " + hElegida.nombre() + " y recupera vida.");
            }
                hElegida.restarUsos();
            //Cambiar turno
            if (turno == 1) {
                turno = 2;
            }
            else{
                turno = 1;
            }

            } else{
                System.out.println("Pierde turno");
            }
        }


        //ganador
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        if (p1.getVida()>0){
            System.out.println("| El ganador es: " + p1.getNombre());
        } else{
            System.out.println("| El ganador es: " + p2.getNombre());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        }

}

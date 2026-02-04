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
        //Contador para  los usos de  furia de  cada personaje
        int contFuriaP1 = 0;
        int contFuriaP2 = 0;
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
            //Para saber si tienen furia
            int tieneFuria;

            if (turno == 1){
                atacante = p1;
                defensor = p2;
                tieneFuria = contFuriaP1;
            } else{
                atacante = p2;
                defensor = p1;
                tieneFuria = contFuriaP2;
            }

            System.out.println("| Turno de " + atacante.getNombre() +" de atacar.");

            //Elegir habilidades
            System.out.println("| Elige una habilidad: |");
            Habilidades h1 = atacante.getHabilidades().get(0);
            Habilidades h2 = atacante.getHabilidades().get(1);
            Habilidades h3 = atacante.getHabilidades().get(2);

            //las habilidades de guerrero
            if (atacante.clase.getNombre().equals("Guerrero")){
                Habilidades h4 = atacante.getHabilidades().get(3);
                System.out.println("| 1. " + h1.nombre() + " | Daño: " + h1.bonificador() + " | Usos: " + h1.getUsos() + " | " + h1.definicion());
                System.out.println("| 2. " + h2.nombre() + " | Cura: " + h2.bonificador() + " | Usos: " + h2.getUsos() + " | " + h2.definicion());
                System.out.println("| 3. " + h3.nombre() + " | Daño: " + h3.bonificador() + " | Usos: " + h3.getUsos() + " | " + h3.definicion());
                System.out.println("| 4. " + h4.nombre() + " | Daño: " + h4.bonificador() + " | Usos: " + h4.getUsos() + " | " + h4.definicion());
            //Para el resto de personajes
            }else{
                System.out.println("| 1. " + h1.nombre() + " | Daño: " + h1.bonificador() + " | Usos: " + h1.getUsos() + " | " + h1.definicion());
                System.out.println("| 2. " + h2.nombre() + " | Cura: " + h2.bonificador() + " | Usos: " + h2.getUsos() + " | " + h2.definicion());
                System.out.println("| 3. " + h3.nombre() + " | Daño: " + h3.bonificador() + " | Usos: " + h3.getUsos() + " | " + h3.definicion());
            }

           int eleccion = s.nextInt();
            int numero = eleccion - 1;
            //al empezar el arrayList por 0, le tenemos que resta 1 a la opcion elegida para que coincida.

            //seleccionar la habilidad elegida
            Habilidades hElegida = atacante.getHabilidades().get(numero);

            if (hElegida.getUsos() > 0) {

            //Si selecciona furia
            if (hElegida.nombre().equals("Furia")) {
                if (atacante == p1){
                    contFuriaP1 = 2;
                } else {
                    contFuriaP2 = 2;
                }
                System.out.println("| "+ atacante.getNombre() + " ha usado Furia. El daño se duplica en las dos siguientes rondas.");
                //Aplicar danio
            } else if (hElegida.getTipo() == 1){
                //Creamos esta variable que guarda el daño que quita para que sea mas facil multiplicar el daño por 2
                int danioTotal = hElegida.bonificador();

                //Si tiene furia activada
                if (tieneFuria > 0){
                    danioTotal = danioTotal * 2;
                    System.out.println("| El daño se duplica al tener furia activada");
                    //restar usos
                    if (atacante == p1){
                        contFuriaP1 --;
                    } else {
                        contFuriaP2 --;
                    }
                }
                int vidaBaja = defensor.getVida() - danioTotal;
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

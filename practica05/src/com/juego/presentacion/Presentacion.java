package com.juego.presentacion;

import com.juego.clases.*;
import com.juego.modelo.Combate;
import com.juego.modelo.GestorPersonajes;
import com.juego.modelo.Personaje;
import com.juego.razas.Elfo;
import com.juego.razas.Enano;
import com.juego.razas.Humano;
import com.juego.razas.Raza;

import java.util.ArrayList;
import java.util.Scanner;

public class Presentacion {
    /*
    1. Jugar
    new Combate()
    dentro de combate:
    1.1 elegir personaje (ArrayList en gestor personajes)
    1.2 turno 1 (bucle)
    p1 -> vida, habilidades con usos
    p2 -> vida, habilidades con usos
    finaliazcion de turno (ha muerto alguno de los dos?)
    2. Crear personaje
    3. Salir
     */
    //Almecena los datos de los personajes
    private GestorPersonajes gestorPersonajes = new GestorPersonajes();
    private Scanner s = new Scanner(System.in);

    public void mostrarMenu(){
        int eleccion = 0;

        //El programa funciona hasta que elijamos las tercera opcion que es salir
        while (eleccion != 3){
            System.out.println("----- MENU PRINCIPAL -----");
            System.out.println("| 1. Jugar (Combate)");
            System.out.println("| 2. Crear personaje");
            System.out.println("| 3. Salir");
            System.out.println("Elige una opción: ");
            eleccion = s.nextInt();

            //Configuramos cada numero con su opcion
            if (eleccion == 1){
                menuCombate();
            } else if (eleccion == 2) {
                menuCrear();
            }
        }
    }

    //Metodo pra gestionar el menu combate
    private void menuCombate(){
        //lista guardada de todos los personajes
        ArrayList<Personaje> listaPersonaje = gestorPersonajes.getListaPersonajes();
        System.out.println("----- PERSONAJES DISPONIBLES -----");

        //Utilizamos el for para que el jugador sepa que numero es cada personaje
        for (int i = 0; i < listaPersonaje.size(); i++) {
            System.out.println(i + ". " +listaPersonaje.get(i).mostrarDatos());
        }

        System.out.println("| Introduce el numero del personaje 1 que quieres utilizar.");
        int id1 = s.nextInt();
        System.out.println("| Introduce el numero del personaje 2 que quieres utilizar.");
        int id2 = s.nextInt();

        //Creamos el combate con los personajes
        Combate combate = new Combate(listaPersonaje.get(id1), listaPersonaje.get(id2));
        //iniciamos el combate
        combate.iniciar();
    }

    //Creacion de los personajes;
    private void menuCrear(){
        System.out.println("| Nombre del personaje: ");
        String nombre = s.next();

        //Seleccionamos la raza
        System.out.println("| Selecciona la raza: 1. Humano | 2. Elfo | 3. Enano");
        Raza raza;
        int r = s.nextInt();
        if (r == 1){
            raza = new Humano();
        } else if (r == 2) {
            raza = new Elfo();
        }else{
            raza = new Enano();
        }

        //Seleccionamos la clase
        System.out.println("| Selecciona la clase: ");
        System.out.println("| 1. Guerrero | 2. Paladin   | 3. Monje | 4. Picaro");
        System.out.println("| 5. Druida   | 6. Sacerdote | 7. Mago  | 8. Bardo ");
        int c = s.nextInt();
        Clase clase;
        if (c == 1){
            clase = new Guerrero();
        } else if (c == 2) {
            clase = new Paladin();
        } else if (c == 3) {
            clase = new Monje();
        } else if (c == 4) {
            clase = new Picaro();
        } else if (c == 5) {
            clase = new Druida();
        } else if (c == 6) {
            clase = new Sacerdote();
        } else if (c == 7) {
            clase = new Mago();
        } else {
            clase = new Bardo();
        }
        //Guardamos los datos del personaje nuevo
        Personaje nuevo = new Personaje(nombre, raza, clase, clase.getHabilidades());

        //Guardamos al personaje en el gestor de personajes
        gestorPersonajes.aniadirPresonaje(nuevo);
        System.out.println("| "  + nombre + " ha sido añadido");
    }
    public static void main(String[] args) {
        new Presentacion().mostrarMenu();
    }

}

package Bloque1;

import java.util.ArrayList;

public class RegistroMuertes {
    public ArrayList<String> registroCombate;
    public RegistroMuertes(){
        registroCombate = new ArrayList<>();

        registroCombate.add("Orco derrotado");
        registroCombate.add("Pocion usada");
        registroCombate.add("Druida curado");
        registroCombate.add("Furia aplicada");
        registroCombate.add("Vida restablecida");

        System.out.println("Registro de Muertes: " + registroCombate.get(2));
    }
}

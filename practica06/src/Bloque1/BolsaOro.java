package Bloque1;

import java.util.HashMap;

public class BolsaOro {
    HashMap<String, Integer>bolsaOro = new HashMap<>();
    public BolsaOro(){
        bolsaOro.put("Jaime",50);
        bolsaOro.put("Adrian",20);
        bolsaOro.put("Ismael",30);
        String nombre = "Ismael";
        System.out.println("Bolsa de oro: el oro de " + nombre + " es " + bolsaOro.get(nombre));
    }
}

package Bloque2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Rastreadorestadistica {
    HashMap<String, HashMap<String,Integer>> jugador = new HashMap<>();
    public Rastreadorestadistica() {
        HashMap<String, Integer> estadisticasConan = new HashMap<>();
        estadisticasConan.put("Fuerza",18);
        estadisticasConan.put("Destreza",12);
        jugador.put("Conan",estadisticasConan);
        HashMap<String, Integer> estadisticash = new HashMap<>();
        estadisticash.put("Fuerza",18);
        estadisticash.put("Destreza",12);
        jugador.put("h",estadisticash);
        if(jugador.containsKey("Conan")){
            int fuerza = estadisticasConan.get("Fuerza")+2;
            estadisticasConan.put("Fuerza",fuerza);
            }
        System.out.println("Estadisticas Conan: " + estadisticasConan);
        }
    }


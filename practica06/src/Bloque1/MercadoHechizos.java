package Bloque1;

import java.util.HashMap;
import java.util.Map;

public class MercadoHechizos {
    HashMap<String, Double> hechizos = new HashMap<>();
    public MercadoHechizos(){
        hechizos.put("Bola ignea",52.5);
        hechizos.put("Escudo Arcano", 45.2);
        hechizos.put("Rayo de hielo", 48.0);
        hechizos.put("Curacion Mayor", 55.5);
        hechizos.put("Invocacion sombria", 60.7);
        System.out.println("Mercado de Hechizos: ");
        for (Map.Entry<String, Double> h: hechizos.entrySet()){
            if (h.getValue()>50.0){
                System.out.println(h.getKey());
            }
        }
    }
}

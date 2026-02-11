package Bloque2;

import java.util.HashMap;
import java.util.HashSet;

public class SistemaLoot {
    HashMap<String, HashSet<String>> monstruos = new HashMap<>();
    public SistemaLoot() {
        HashSet<String> lootTrasgo = new HashSet<>();
        lootTrasgo.add("Espada oxidada");
        lootTrasgo.add("oro");
        //Añadimos otra espada oxidada(al ser hashset el programa la ignora automaticamente);
        lootTrasgo.add("Espada oxidada");
        monstruos.put("Trasgo",lootTrasgo);
    }
    public void objetosPosee(){
        System.out.println("Sistema loot: Loot del monstruo: " + monstruos.get("Trasgo"));
    }
}

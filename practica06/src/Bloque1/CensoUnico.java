package Bloque1;

import java.util.HashSet;

public class CensoUnico {
    public HashSet<String> nombreVillanos;
    public CensoUnico() {
        nombreVillanos = new HashSet<>();
        nombreVillanos.add("Thanos");
        nombreVillanos.add("Morgoth");
        nombreVillanos.add("Morgoth");

        System.out.println("Censo unico: " + nombreVillanos);
    }
}

package Bloque1;

public class ExpulsionReino {
    public ExpulsionReino(){
        System.out.println("-----Ejercicio 6-----");
    CensoUnico villanos = new CensoUnico();
    if(villanos.nombreVillanos.contains("Sauron")){
        villanos.nombreVillanos.remove("Sauron");
        System.out.println("Expulsión del reino: Sauron ha sido derrotado");
        System.out.println(villanos.nombreVillanos);
    } else {
        System.out.println(villanos.nombreVillanos);
    }
    }
}

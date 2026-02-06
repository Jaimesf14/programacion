package Bloque1;

public class LimpiezaCalabozo {
    public LimpiezaCalabozo(){
        //invocamos el array del ejercicio1
        RegistroMuertes muertes =new RegistroMuertes();
        System.out.println("Array registro muerte: " + muertes.registroCombate);
        muertes.registroCombate.remove(0);
        muertes.registroCombate.add("Dragón avistado");
        System.out.println("Limpieza calabozo: " + muertes.registroCombate);

    }
}

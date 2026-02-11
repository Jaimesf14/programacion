import java.util.ArrayList;
import java.util.HashMap;

public class Bloque2 {

    public void RepositoriosGremios() {
        HashMap<String, ArrayList<String>> gremios = new HashMap<>();
        ArrayList<String> miembros1 =new ArrayList<>();
        miembros1.add("Jaime");
        miembros1.add("Ismael");
        miembros1.add("Jose Manuel");

        ArrayList<String> miembros2 =new ArrayList<>();
        miembros2.add("Adrian");
        miembros2.add("Roberto");
        miembros2.add("Iker");

        gremios.put("Magos", miembros1);
        gremios.put("Guerreros", miembros2);
        getImprimirGremios(gremios,"Magos");

    }
    public void getImprimirGremios(HashMap<String,ArrayList<String>>gremios, String nombreGremio){
        if(gremios.containsKey(nombreGremio)){
            System.out.println("Miembros del gremio " + nombreGremio +":");
            for (String miembros : gremios.get(nombreGremio)){
                System.out.println(miembros);
            }
        } else {
            System.out.println("No existe el gremio");
        }
    }
}

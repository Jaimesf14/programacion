import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bloque2 {

    /*El Repositorio de Gremios: Crea un HashMap<String, ArrayList<String>>. La clave es el nombre del gremio (ej: "Magos")
    y el valor es una lista de sus miembros. Agrega 2 gremios con 3 miembros cada uno y programa una función que imprima
    solo los miembros de un gremio específico.*/

    public void RepositoriosGremios() {
        System.out.println("-----Ejercicio 7-----");
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

        //función que imprima solo los miembros de un gremio específico.
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
        System.out.println("------------------------------------");
    }

    /*El Sistema de Loot (Botín): Crea un HashMap<String, HashSet<String>> donde cada Monstruo tiene un set de Objetos
    que puede soltar.
    Si el "Trasgo" suelta una "Espada Oxidada" y tú intentas añadirle otra "Espada Oxidada" por error, el sistema debe
    ignorarlo automáticamente.*/

    public void SistemaLoot() {
        System.out.println("-----Ejercicio 8-----");
        HashMap<String, HashSet<String>> monstruos = new HashMap<>();

        HashSet<String> lootTrasgo = new HashSet<>();
        lootTrasgo.add("Espada oxidada");

        lootTrasgo.add("oro");
        //Añadimos otra espada oxidada(al ser hashset el programa la ignora automaticamente);
        lootTrasgo.add("Espada oxidada");

        monstruos.put("Trasgo",lootTrasgo);
        System.out.println("Sistema loot: Loot del monstruo: " + monstruos.get("Trasgo"));
        System.out.println("------------------------------------");
    }

    /*Rastreador de Estadísticas Complejas: Crea un HashMap<String, HashMap<String, Integer>>.
    La clave principal es el Nombre del Jugador.
    El valor es OTRO HashMap que contiene sus estadísticas (ej: {"Fuerza": 18, "Destreza": 12}).
    Reto: Escribe el código para buscar a "Conan" y sumarle +2 a su estadística de "Fuerza".*/

    public void RastreadorEstadistica() {
        System.out.println("-----Ejercicio 9-----");
        HashMap<String, HashMap<String,Integer>> jugador = new HashMap<>();

        //Datos Conan
        HashMap<String, Integer> estadisticasConan = new HashMap<>();
        estadisticasConan.put("Fuerza",18);
        estadisticasConan.put("Destreza",12);

        jugador.put("Conan",estadisticasConan);
        //Datos Dutch
        HashMap<String, Integer> estadisticasDutch = new HashMap<>();
        estadisticasDutch.put("Fuerza",18);
        estadisticasDutch.put("Destreza",15);
        jugador.put("Dutch",estadisticasDutch);

        //Escribe el código para buscar a "Conan" y sumarle +2 a su estadística de "Fuerza"
        if(jugador.containsKey("Conan")){
            int fuerza = estadisticasConan.get("Fuerza")+2;
            estadisticasConan.put("Fuerza",fuerza);
            System.out.println("Estadisticas Conan: " + estadisticasConan);
            System.out.println("Estadisticas Dutch: " + estadisticasDutch);
        }else{
            System.out.println("Estadisticas Conan: " + estadisticasConan);
            System.out.println("Estadisticas Dutch: " + estadisticasDutch);
        }
        System.out.println("------------------------------------");
    }

    /*Buscador de Traidores: Tienes un HashMap<String, ArrayList<String>> de Gremios (como en el ej. 7). Escribe un
    algoritmo que recorra todos los gremios y verifique si un aventurero llamado "Judas" está escondido en alguno de
    ellos. Si lo encuentra, debe imprimir en qué gremio está y eliminarlo de la lista de ese gremio inmediatamente.*/

    public void BuscadorTaidores(){
        System.out.println("-----Ejercicio 10-----");
        HashMap<String, ArrayList<String>> gremios = new HashMap<>();

        ArrayList<String> miembros1 =new ArrayList<>();
        miembros1.add("Juan");
        miembros1.add("Mateo");
        miembros1.add("Pablo");

        ArrayList<String> miembros2 =new ArrayList<>();
        miembros2.add("Santiago");
        miembros2.add("Pedro");
        miembros2.add("Judas");

        gremios.put("Magos", miembros1);
        gremios.put("Guerreros", miembros2);

        //recorra todos los gremios y verifique si un aventurero llamado "Judas" está escondido en alguno de ellos. //Recorrer los nombres de los gremios
        for (String gremio : gremios.keySet()){
            //recorre los nombres
            for (String nombres : gremios.get(gremio)){
                if (nombres.equals("Judas")){

                    //Si lo encuentra, debe imprimir en qué gremio está y eliminarlo de la lista de ese gremio inmediatamente
                    gremios.get(gremio).remove("Judas");
                    break;
                }
            }

        }
        System.out.println("El traidor ha sido eliminado de su gremio. Resultado miembros de los gremios: "+ gremios );
        System.out.println("------------------------------------");
    }
}


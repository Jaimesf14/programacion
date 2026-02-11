import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Bloque1 {
    public ArrayList<String> RegistroMuertes() {
        System.out.println("---Ejercicio 1---");
            ArrayList <String> registroCombate = new ArrayList<>();
            registroCombate.add("Orco derrotado");
            registroCombate.add("Pocion usada");
            registroCombate.add("Druida curado");
            registroCombate.add("Furia aplicada");
            registroCombate.add("Vida restablecida");

            System.out.println("Registro de Muertes: " + registroCombate.get(2));
        System.out.println("------------------------------------");
        return registroCombate;
        }
        public HashSet<String> CensoUnico(){
            System.out.println("---Ejercicio 2---");
            HashSet<String> nombreVillanos = new HashSet<>();
            nombreVillanos = new HashSet<>();
            nombreVillanos.add("Thanos");
            nombreVillanos.add("Morgoth");
            nombreVillanos.add("Morgoth");
            nombreVillanos.add("Sauron");

        System.out.println("Censo unico: " + nombreVillanos);
            System.out.println("------------------------------------");
        return nombreVillanos;
        }

        public void BolsaOro(){
            System.out.println("---Ejercicio 3---");
            HashMap<String, Integer> bolsaOro = new HashMap<>();
            bolsaOro.put("Jaime",50);
            bolsaOro.put("Adrian",20);
            bolsaOro.put("Ismael",30);
            String nombre = "Ismael";
            System.out.println("Bolsa de oro: el oro de " + nombre + " es " + bolsaOro.get(nombre));
            System.out.println("------------------------------------");
        }
        public void LimpiezaCalabozo(ArrayList<String> muerte ){
            System.out.println("---Ejercicio 4---");
            System.out.println("Array registro muerte: " + muerte);
            muerte.remove(0);
            muerte.add("Dragón avistado");
            System.out.println("Limpieza calabozo: " + muerte);
            System.out.println("------------------------------------");
        }

        public void MercadoHechizos(){
            System.out.println("---Ejercicio 5---");
            HashMap<String, Double> hechizos = new HashMap<>();
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
            System.out.println("------------------------------------");
        }
        public void ExpulsionReino(HashSet<String> nombreVillanos){
            System.out.println("-----Ejercicio 6-----");

            if(nombreVillanos.contains("Sauron")){
                nombreVillanos.remove("Sauron");
                System.out.println("Expulsión del reino: Sauron ha sido derrotado");
                System.out.println(nombreVillanos);
            } else {
                System.out.println(nombreVillanos);
        }
            System.out.println("------------------------------------");
    }
    }


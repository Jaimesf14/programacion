package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rpg.model.Personaje;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonHelper {
    public static void leerPersonajes(){
        try{
            Reader reader = Files.newBufferedReader(Paths.get("practica07/ficheros/personajes.json"));
            List<Personaje> lista = new Gson().fromJson(
                    reader,
                    new TypeToken<List<Personaje>>(){
                    }.getType()
            );
            System.out.println("---PERSONAJES---");
            for (Personaje p : lista){
                System.out.println("Personajes: " + p.getNombre() + ", " + p.getRaza() + ", " + p.getNivel() +", " + p.getEquipo());
            }
        } catch (IOException e) {
            System.out.println("No se ha podido abrir el fichero.");
        }
    }
}

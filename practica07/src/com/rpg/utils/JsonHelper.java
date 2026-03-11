package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rpg.model.Personaje;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class JsonHelper {

    //Carga generica
    public <T> List<T> readList(String path, Class<T> clazz){
        try(Reader reader = new FileReader(path)){
            Gson gson = new Gson();
            Type TypeOfT = TypeToken.getParameterized(List.class, clazz).getType();
            LoggerCustom.log("[" + LocalDateTime.now() + "] INFO: El archivo " + path +" ha sido leido");
            return gson.fromJson(reader, TypeOfT);
        } catch (Exception e){
            LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            return List.of();
        }
    }

    //Guarda la lista de personajes actualizada en el JSON.
    public <T> void writeList(String path, List<T> lista){
        try(Writer writer = new FileWriter(path)){
            Gson gson = new Gson();
            gson.toJson(lista,writer);
            LoggerCustom.log("[" + LocalDateTime.now() + "] INFO: El archivo " + path +" ha sido escrito");
        } catch (IOException e){
            LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getClass().getSimpleName() + " - " + e.getMessage());

        }
    }
}



    /*public static void leerPersonajes(){
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
}*/

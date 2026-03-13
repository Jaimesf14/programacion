package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

public class JsonHelper {

    //Carga generica
    public <T> List<T> readList(String path, Class<T> clazz){
        try(Reader reader = new FileReader(path)){
            Gson gson = new Gson();
            Type TypeOfT = TypeToken.getParameterized(List.class, clazz).getType();
            LoggerCustom.log("[" + LocalDateTime.now() + "] INFO: Archivo leído -> " + path);
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
            LoggerCustom.log("[" + LocalDateTime.now() + "] INFO: Archivo escrito -> " + path);
        } catch (IOException e){
            LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getClass().getSimpleName() + " - " + e.getMessage());

        }
    }
}




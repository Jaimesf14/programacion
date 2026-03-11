package com.rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerCustom {
    
    public static  void log(String mensaje){
        String path = "practica07/ficheros/errores.log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))){
            writer.write(mensaje);
            writer.newLine();
        }catch (IOException e){
            System.out.println("Error " + e.getMessage());
        }
    }
}

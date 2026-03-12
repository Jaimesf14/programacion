package com.rpg.utils;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.FormatoInvalidoException;
import com.rpg.model.Ciudad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class TxtHelper {
    public static List<Ciudad> leerCiudades() {
        List<Ciudad> listaCiudades = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get("practica07/ficheros/ciudades.txt"));
            for (String linea : lineas) {
                //Si hay comentarios o lineas en blanco lo ignora
                if (linea.startsWith("#")|| linea.isBlank()){
                    continue;
                }
                try {
                    String[] s = linea.split(";");
                    if (s.length != 4) {
                        throw new DatoInvalidoException("Formato incorrecto en línea: " + linea);
                    }
                    //creamos un objeto ciudad y lo agregamos a la lista
                    Ciudad c = new Ciudad(
                            s[0],
                            Integer.parseInt(s[1]),
                            s[2],
                            Integer.parseInt(s[3])
                    );
                    listaCiudades.add(c);

                } catch (DatoInvalidoException e) {
                    // comprobamos en log sin interrumpir la carga
                    LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getClass().getSimpleName() + " - " + e.getMessage());
                }
            }
            System.out.println(listaCiudades);

        } catch (IOException e) {
            LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getClass().getSimpleName() + " - " + e.getMessage());

        }
        return listaCiudades;
    }

}
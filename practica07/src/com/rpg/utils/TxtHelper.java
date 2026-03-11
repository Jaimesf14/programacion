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
    public static void leerCiudades() {
        try {
            List<String> lineas = Files.readAllLines(Paths.get("practica07/ficheros/ciudades.txt"));
            if (lineas.isEmpty()) {
                System.out.println("El fichero está vacío");
                throw new FormatoInvalidoException("El fichero ciudades.txt está vacío");
            }
            List<Ciudad> listaCiudades = new ArrayList<>();
            for (String linea : lineas) {
                try {
                    String[] s = linea.split(";");
                    if (s.length != 4) {
                        throw new DatoInvalidoException("El fichero ciudades.txt es inválido");
                    }
                    Ciudad c = new Ciudad(
                            s[0],
                            Integer.parseInt(s[1]),
                            s[2],
                            Integer.parseInt(s[3])
                    );
                    listaCiudades.add(c);

                } catch (DatoInvalidoException e) {
                    LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: "
                            + e.getClass().getSimpleName() + " - " + e.getMessage());
                }
            }
            System.out.println(listaCiudades);

        } catch (IOException | FormatoInvalidoException e) {
            LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: "
                    + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
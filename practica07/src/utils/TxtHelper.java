package utils;

import com.rpg.model.Ciudad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class TxtHelper {
    public static  void leerCiudades(){
        try{
            List<String> lineas = Files.readAllLines(Paths.get("practica07/ficheros/ciudades.txt"));
            List<Ciudad>listaCiudades = new ArrayList<>();

            System.out.println("---Contenido del fichero---");
            System.out.println("---CIUDADES---");
            for (String linea: lineas){

                String[] s = linea.split(";");
                Ciudad c = new Ciudad(
                    s[0],
                    Integer.parseInt(s[1]),
                    s[2],
                    Integer.parseInt(s[3])
                );
                listaCiudades.add(c);
                System.out.println("Ciudad: "+c.getNombre() + ", " + ", " + c.getPoblacion() + ", " + c.getClima() + ", " + c.getRiesgo());
                System.out.println("Total de lineas: " + lineas.size());
            }

        } catch (IOException e) {
            System.out.println("No se ha podido abrir el fichero.");
        }
    }
}
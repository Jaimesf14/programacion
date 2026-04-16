package rpg.utils;

import java.io.BufferedWriter;
import java.io.IOException;

public class LoggerCustom {

    // Escribe un mensaje en errores.log
    public static  void info(String mensaje){
        String path = "practica07/ficheros/info.log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))){
            writer.write(mensaje);
            writer.newLine();
        }catch (IOException e){
            System.out.println("Error " + e.getMessage());
        }
    }
}

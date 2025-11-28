import java.awt.geom.Area;
import java.util.ArrayList;

public class Hospital {
    //Atributos
    private  String nombre;
    private  String CIF;
    private  ArrayList<Area> arrayArea;

    //Constructor
    public Hospital(String nom, String cif,ArrayList area){
        this.nombre = nom;
        this.CIF = cif;
        this.arrayArea = new ArrayList<>();
    }
    //Metodos get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }


    public ArrayList<Area> getArea() {
        return arrayArea;
    }

    public void setArea(ArrayList<Area> area) {
        this.arrayArea = area;
    }
}


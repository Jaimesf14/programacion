import java.awt.geom.Area;
import java.util.ArrayList;

public class Hospital {
    //Atributos
    private  String nombre;
    private  String CIF;
    private  ArrayList<Area> area = new ArrayList<>();

    //Constructor
    public Hospital(String nom, String cif,ArrayList area){
        this.nombre = nom;
        this.CIF = cif;
        this.area = area;
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
        return area;
    }

    public void setArea(ArrayList<Area> area) {
        this.area = area;
    }
}


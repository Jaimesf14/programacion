
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
    //Para agregar un area al arrayArea
    public void agregarArea(Area area){
        this.arrayArea.add(area);
    }
    //calculamos el numero total de medicos
    public int getNumeroTotalMedicos(){
        int total = 0;
        for (int i = 0; i < arrayArea.size(); i++) {
            //el area.size sirve para saber las areas del hospital,
            // con el area.get(i) sabemos la posicion concreta del area,
            // y con el getNumMedicos sabemos los medicos que tiene esa area.
            total+= arrayArea.get(i).getNumMedicos();
        }
        return total;
    }
    //comprobar si ya existe un area con el ID dado
    public boolean existeArea(String idArea){
        for (int i = 0; i < arrayArea.size(); i++) {
            Area area = arrayArea.get(i);
            //comparamos el getIdentificador con el idArea que recibimos
            if (area.getIdentificador().equals(idArea)){
                return true;
            }
        }
        return false;

    }
}



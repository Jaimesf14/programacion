public class Area {
    //Atributos
    private  String nombre;
    private  String identificador;
    private  int planta;
    private Hospital hospital;
    private  int numMedicos;
    //Constructor
    public Area(String nom, String id, int planta, Hospital hosp){
        this.nombre = nom;
        this.identificador = id;
        this.planta = planta;
        this.hospital = hosp;
        this.numMedicos = 0;
    }
    //metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public int getNumMedicos() {
        return numMedicos;
    }

    public void incrementarNumMedicos() {
        this.numMedicos++;
    }
    public void decrementarNumMedicos() {
        if(numMedicos<0) {
            this.numMedicos--;
        }
    }
    public void cambiarArea(Area nuevaArea) {
        this.decrementarNumMedicos();
        nuevaArea.incrementarNumMedicos();
    }
}

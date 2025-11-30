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

    //incremento y decremento de medicos
    public void incrementarNumMedicos() {
        this.numMedicos++;
    }
    public void decrementarNumMedicos() {
        if(numMedicos>0) {
            this.numMedicos--;
        }
    }

    //Comprobacion y comparación
    public String compararMedicos(Area otraArea){
        if (otraArea == null){
            return "El área que se quiere comparar no existe";
        } else if (this.numMedicos > otraArea.numMedicos){
            return "El área " + this.nombre + " tiene mas médicos que el área " + otraArea.nombre;
        } else if (this.numMedicos < otraArea.numMedicos){
            return "El área " + otraArea.nombre + " tiene mas médicos que el área " + this.nombre;
        } else {
            return "Las dos áreas tienen el mismo número de médicos";
        }
    }

    //Calcular la capacidad restante
    public int calcularCapacidadRestante(int capacidadMaxima){
        int capacidadRestante = capacidadMaxima - this.numMedicos;
        //Math.max lo que hace es encontrar el valor mas grande entre los dos numeros del parentesis, y
        // por tanto, siempre que haya capacidad restante, devolverá ese valor, ya que el otro al que se
        // está comparando es 0.
        return Math.max(capacidadRestante, 0);
    }
}



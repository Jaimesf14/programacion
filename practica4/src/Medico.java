public class Medico {
    //atributos
    private  String DNI;
    private  String nombre;
    private  int edad;
    private  String sexo;
    private double sueldoBruto;
    private String fechaInicio;
    private Area area;
    //constructor
    public Medico(String DNI, String nom, int ed, String sex, double sueldo, String fechI, Area area){
        this.DNI = DNI;
        this.nombre = nom;
        this.edad = ed;
        this.sexo = sex;
        this.sueldoBruto = sueldo;
        this.fechaInicio = fechI;
        this.area = area;
        area.incrementarNumMedicos();
    }
    //Metodo get y set

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public double calcularSueldoNeto(double retencion){

    }
}

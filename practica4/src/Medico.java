import java.time.Year;

public class Medico {
    //atributos
    private  String DNI;
    private  String nombre;
    private  int edad;
    private  String sexo;
    private double sueldoBruto;
    private int fechaInicio;
    private Area area;
    private int aniosAntiguedad;
    //constructor
    public Medico(String DNI, String nom, int ed, String sex, double sueldo, int fechI, Area area, int antiguedad){
        this.DNI = DNI;
        this.nombre = nom;
        this.edad = ed;
        this.sexo = sex;
        this.sueldoBruto = sueldo;
        this.fechaInicio = fechI;
        this.area = area;
        this.aniosAntiguedad = antiguedad;
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

    public int getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    //calculo sueldo neto
    public double calcularSueldoNeto(double retencion){
        //suponemos que el porcetaje de retencion es del 5%
        return this.sueldoBruto - this.sueldoBruto * (retencion/100);
    }
    //Calculamos los años de antiguedad
    public int getAniosAntiguedad() {
        return this.aniosAntiguedad;
    }

    public void setAniosAntiguedad(int aniosAntiguedad) {
        //Creamos lavariable anio, y le selccionamos el año actual.
        int anio = Year.now().getValue();
        this.aniosAntiguedad = anio - this.fechaInicio;
    }

    //Calculamos los impuestos anuales
    public double calcularImpuestosAnuales(double tasaImpositiva){
        //Suponemos que el porcentaje de la tasa impositiva es de un 25%
        return this.sueldoBruto * (25/100.0);
    }

    //Calculamos si es mayor de edad
    public boolean esMayorDeEdad(int mayoriaEdad){
        return this.edad >= mayoriaEdad;
    }

    //Calculamos el aumento
    public double proximoAumento(double porcentajeAumento, int aniosRequeridos){
        double resultado = sueldoBruto;
        if (aniosAntiguedad >= aniosRequeridos) {
            double sueldoBrutoAumentado;
            sueldoBrutoAumentado = this.sueldoBruto + ((porcentajeAumento/100)*this.sueldoBruto);
            resultado = sueldoBrutoAumentado;
        }
        return resultado;
    }

    //gestion de area
    public void cambiarArea(Area nuevaArea) {
        this.area.decrementarNumMedicos();
        this.area = nuevaArea;
        nuevaArea.incrementarNumMedicos();

    }
}



public class Direccion {
    //Atributos
    private  String calle;
    private  int numero;
    private  int codigoPostal;
    private  String localidad;
    private  String provincia;

    //Constructor
    public Direccion(String calle, int num, int codP, String loc, String prov) {

        this.calle = calle;
        this.numero = num;
        this.codigoPostal = codP;
        this.localidad = loc;
        this.provincia = prov;

    }
    //Metodos get y set


    public  String getCalle() {
        return calle;
    }

    public  void setCalle(String calle) {
        this.calle = calle;
    }

    public  int getNumero() {
        return numero;
    }

    public  void setNumero(int numero) {
        this.numero = numero;
    }

    public  int getCodigoPostal() {
        return codigoPostal;
    }

    public  void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public  String getLocalidad() {
        return localidad;
    }

    public  void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public  String getProvincia() {
        return provincia;
    }

    public  void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}


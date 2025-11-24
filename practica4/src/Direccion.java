public class Direccion {
    //Atributos
    private static String calle;
    private static int numero;
    private static int codigoPostal;
    private static String localidad;
    private static String provincia;

    //Constructor
    public Direccion(String ca, int nu, int co, String lo, String pr) {

        this.calle = ca;
        this.numero = nu;
        this.codigoPostal = co;
        this.localidad = lo;
        this.provincia = pr;

    }
    //Metodos get y set


    public static String getCalle() {
        return calle;
    }

    public static void setCalle(String calle) {
        Direccion.calle = calle;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Direccion.numero = numero;
    }

    public static int getCodigoPostal() {
        return codigoPostal;
    }

    public static void setCodigoPostal(int codigoPostal) {
        Direccion.codigoPostal = codigoPostal;
    }

    public static String getLocalidad() {
        return localidad;
    }

    public static void setLocalidad(String localidad) {
        Direccion.localidad = localidad;
    }

    public static String getProvincia() {
        return provincia;
    }

    public static void setProvincia(String provincia) {
        Direccion.provincia = provincia;
    }
}

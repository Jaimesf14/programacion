public class Usuario {
    //ATRIBUTOS
    private String nombre;
    private String apellidos;
    private String codigoPostal;
    private String direccion;
    private String email;
    private String contrasena;
    //CONSTRUCTOR
    public Usuario(String nom, String ap, String codPos, String dir, String em, String con) {
        this.nombre = nom;
        this.apellidos = ap;
        this.codigoPostal = codPos;
        this.direccion = dir;
        this.email = em;
        this.contrasena = con;
    }
    //METODOS GET Y SET
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String nuevoEmail) {
        if (nuevoEmail.contains("@")){
            this.email =  nuevoEmail;
        } else {
            System.out.println("Error: Email inválido. No contiene @.");
        }

    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }



    public boolean checkUsuario(String email, String contrasena){

        return this.getEmail().equals(email) && this.contrasena.equals(contrasena);
    }
    //METODO TOSTRING

    public String toString() {
        return "El nombre es " + this.nombre + " " + this.apellidos +", el email es " + this.email + "y el código " +
                "postal es " + this.codigoPostal;
    }
}


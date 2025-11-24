public class Contrato {
    private String fechaCreacion;
    private Medico medico;
    private Hospital hospital;
    public Contrato(String fechaC, Medico medico, Hospital hosp){
        this.fechaCreacion = fechaC;
        this.medico = medico;
        this.hospital = hosp;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}

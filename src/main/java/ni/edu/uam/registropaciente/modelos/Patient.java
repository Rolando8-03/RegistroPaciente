package ni.edu.uam.registropaciente.modelos;

import java.time.LocalDate;

public class Patient {

    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String genero;
    private boolean tieneSeguro;

    public Patient() {
    }

    public Patient(String nombres, String apellidos, LocalDate fechaNacimiento,
                   String genero, boolean tieneSeguro) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.tieneSeguro = tieneSeguro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isTieneSeguro() {
        return tieneSeguro;
    }

    public void setTieneSeguro(boolean tieneSeguro) {
        this.tieneSeguro = tieneSeguro;
    }
}

package modelo;

import java.io.Serializable;

public abstract class Personas implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nan;
    private String nombre;
    private String apellidos;
    private String anyo;
    private String direccion;

    public Personas(String nan, String nombre, String apellidos, String anyo, String direccion) {
        this.nan = nan;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anyo = anyo;
        this.direccion = direccion;
    }

    public String getNan() {
        return nan;
    }

    public void setNan(String nan) {
        this.nan = nan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

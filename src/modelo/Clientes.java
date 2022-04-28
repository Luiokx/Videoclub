package modelo;

import java.io.Serializable;

public class Clientes extends Personas implements Serializable {
    private String fechaRegistro;

    private static final long serialVersionUID = 1L;
    public Clientes(String nan, String nombre, String apellidos, String anyo, String direccion, String fechaRegistro) {
        super(nan, nombre, apellidos, anyo, direccion);
        this.fechaRegistro = fechaRegistro;
    }

}

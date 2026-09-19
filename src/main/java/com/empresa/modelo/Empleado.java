package com.empresa.modelo;

/**
 *
 * @author kathy
 */

import java.time.LocalDate;

public class Empleado {
    private int id;
    private String nombre;
    private String apellidos;
    private String puesto;
    private LocalDate fechaContratacion;

    public Empleado() {}

    public Empleado(int id, String nombre, String apellidos, String puesto, LocalDate fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.fechaContratacion = fechaContratacion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }
}

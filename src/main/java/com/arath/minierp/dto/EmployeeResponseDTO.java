package com.arath.minierp.dto;


public class EmployeeResponseDTO {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String puesto;

    public EmployeeResponseDTO() {
    }

    public EmployeeResponseDTO(int id,
                               String nombre,
                               String apellido,
                               String email,
                               String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
package com.arath.minierp.model;

import java.time.LocalDate;
import java.util.Objects;


public class Employee {

    private int id;

    private String nombre;
    private String apellido;

    private String email;
    private String telefono;

    private LocalDate fechaNacimiento;    
    private Puesto puesto;
    private Genero genero;

    public enum Genero{
                    HOMBRE,
                    MUJER
                }
    public enum Puesto {
    BACKEND, FRONTEND, FULLSTACK, SOPORTE_TECNICO, RECURSOS_HUMANOS, ANALISTA
}

    public Employee(int id, String nombre, String apellido, LocalDate fechaNacimiento, String email, String telefono, Puesto puesto,
            Genero genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.puesto = puesto;
        this.genero = genero;
 
        
            }

    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    @Override
    public String toString() {
    return "Employee{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
            ", email='" + email + '\'' +
            ", telefono='" + telefono + '\'' +
            ", puesto='" + puesto + '\'' +
            ", genero=" + genero +
            ", fechaNacimiento=" + fechaNacimiento +
            '}';

        
        }

   @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Employee)) return false;
    Employee that = (Employee) o;
    return id == that.getId();
}

@Override
public int hashCode() {
    return Objects.hash(id);
}
    }
            
        
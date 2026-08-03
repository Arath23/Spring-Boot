package com.arath.minierp.viewmodel;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;


import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;
import com.arath.minierp.config.SpringContext;
import com.arath.minierp.dto.EmployeeRequestDTO;
import com.arath.minierp.dto.EmployeeResponseDTO;
import com.arath.minierp.model.Employee;
import com.arath.minierp.service.EmployeeService;

public class EmployeeViewModel {
    private String nombre;
    private String apellido;
    private String email;
    private String puesto;
    private String fechaNacimientoTexto;


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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFechaNacimientoTexto() {
    return fechaNacimientoTexto;
}

public void setFechaNacimientoTexto(String fechaNacimientoTexto) {
    this.fechaNacimientoTexto = fechaNacimientoTexto;
}

    private EmployeeService employeeService;

    private List<EmployeeResponseDTO> empleados;

    private EmployeeResponseDTO empleadoSeleccionado;

    private EmployeeRequestDTO nuevoEmpleado;

    public EmployeeRequestDTO getNuevoEmpleado() {
        return nuevoEmpleado;
    }

    public void setNuevoEmpleado(EmployeeRequestDTO nuevoEmpleado) {
        this.nuevoEmpleado = nuevoEmpleado;
    }

    @Init
    public void inicializar() {
        employeeService = SpringContext.getBean(EmployeeService.class);
        empleados = employeeService.listarEmpleados();

        nuevoEmpleado = new EmployeeRequestDTO();
    }

    public List<EmployeeResponseDTO> getEmpleados() {
        return empleados;
    }

    public EmployeeResponseDTO getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(
            EmployeeResponseDTO empleadoSeleccionado) {

        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    @Command
    @NotifyChange({"empleados", "empleadoSeleccionado"})
    public void actualizarEmpleado(){

        if(empleadoSeleccionado == null){
            return;

        }
        
        Employee empleado = employeeService.buscarEmpleadoPorId(
            empleadoSeleccionado.getId()
        );

        empleado.setNombre(empleadoSeleccionado.getNombre());
        empleado.setApellido(empleadoSeleccionado.getApellido());
        empleado.setEmail(empleadoSeleccionado.getEmail());
        empleado.setPuesto(Employee.Puesto.valueOf(empleadoSeleccionado.getPuesto().toUpperCase())
    );

    employeeService.actualizarEmpleado(empleado);

    empleados = employeeService.listarEmpleados();
    }

    @Command
    @NotifyChange({"empleados", "nuevoEmpleado","fechaNacimientoTexto"})
    public void guardarEmpleado(){

        try{
            LocalDate fecha = LocalDate.parse(fechaNacimientoTexto);

            nuevoEmpleado.setFechaNacimiento(fecha);
        
        employeeService.guardarEmpleado(nuevoEmpleado);
        empleados = employeeService.listarEmpleados();
        nuevoEmpleado = new EmployeeRequestDTO();
        fechaNacimientoTexto="";

        Messagebox.show("Empleado guardado correctamente.");
        } catch(DateTimeException e) {
            Messagebox.show(
                "Fecha invalida"
            );
        }
    }
   
    
}
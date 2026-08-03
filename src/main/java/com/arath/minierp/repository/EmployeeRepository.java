package com.arath.minierp.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.arath.minierp.model.Employee;
import com.arath.minierp.model.Employee.Genero;
import com.arath.minierp.model.Employee.Puesto;

@Repository
public class EmployeeRepository{

    private final List<Employee> empleados = new ArrayList<>();
            private int siguienteId = 1;


    public EmployeeRepository() {

        empleados.add(new Employee(
            1,
            "Arath Daniel",
            "Noiega Dominguez",
            LocalDate.of(2002,  10, 1),
            "arath@email.com",
            "+5544778844",
             Puesto.BACKEND,
            Genero.HOMBRE  ));

        empleados.add(new Employee(
            2,
            "Juan Alejandro",
            "Espinosa Rodriguez",
            LocalDate.of(2001, 05, 15),
            "alejer@email.com",
            "+5544112233",
            Puesto.RECURSOS_HUMANOS,
            Genero.HOMBRE
        ));
    }
    
    public List<Employee> listarEmpleados() {
        return empleados;
    }
    public Optional<Employee> buscarEmpleadoPorId(int id) {
        return empleados.stream()
            .filter(empleado -> empleado.getId() == id)
            .findFirst();
    }

   public void guardarEmpleado(Employee empleado) {
    empleado.setId(siguienteId);
    siguienteId++;

    empleados.add(empleado);
}
    public Employee actualizarEmpleado(Employee empleado){
     Optional<Employee> empleadoOptional = buscarEmpleadoPorId(empleado.getId());
        if (empleadoOptional.isPresent()){
            Employee empleadoActual = empleadoOptional.get();

        empleadoActual.setNombre(empleado.getNombre());
        empleadoActual.setApellido(empleado.getApellido());
        empleadoActual.setFechaNacimiento(empleado.getFechaNacimiento());
        empleadoActual.setEmail(empleado.getEmail());
        empleadoActual.setTelefono(empleado.getTelefono());
        empleadoActual.setPuesto(empleado.getPuesto());
        empleadoActual.setGenero(empleado.getGenero());

        return empleadoActual;
        }
        return null;
    }

    public Employee eliminarEmpleado(int id){
        Optional<Employee> empleadoOptional = buscarEmpleadoPorId(id);

        if(empleadoOptional.isPresent()){
            Employee empleado = empleadoOptional.get();
            empleados.remove(empleado);
            return empleado;
        }
        return null;
    }
}

package com.arath.minierp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arath.minierp.dto.EmployeeResponseDTO;
import com.arath.minierp.exception.EmpleadoEncontradoException;
import com.arath.minierp.exception.EmpleadoNoEncontradoException;
import com.arath.minierp.model.Employee;
import com.arath.minierp.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeResponseDTO> listarEmpleados() {
        return repository.listarEmpleados()
            .stream()
            .map(this::convertirDTO)
            .toList();
    }

    public Employee buscarEmpleadoPorId(int id) {
        return repository.buscarEmpleadoPorId(id)
        .orElseThrow(() -> new EmpleadoNoEncontradoException(
            "No existe un empleado con ese id" +" "+  id));
    }

    public Employee guardarEmpleado(Employee empleado) {
        if (repository.buscarEmpleadoPorId(empleado.getId()).isPresent()) {
            throw new EmpleadoEncontradoException(
                "Ya existe un empleado con id " + empleado.getId());
        }
        repository.guardarEmpleado(empleado);
        return empleado;
    }

        public Employee actualizarEmpleado(Employee empleado){
        if (repository.buscarEmpleadoPorId(empleado.getId()).isEmpty()){
            throw new EmpleadoEncontradoException(
                "No existe un empleado con ese id "  + empleado.getId()
            );
        }
            return repository.actualizarEmpleado(empleado);
        }

        public Employee eliminarEmpleado(int id){
            if (repository.buscarEmpleadoPorId(id).isEmpty()){
                throw new EmpleadoEncontradoException(
                    "No existe un empleado con ese id" + id);
                
            }
            return repository.eliminarEmpleado(id);
        }

        private EmployeeResponseDTO convertirDTO(Employee empleado) {
            return new EmployeeResponseDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getEmail(),
                empleado.getPuesto().name()
            );
        }
}

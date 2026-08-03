package com.arath.minierp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arath.minierp.dto.EmployeeRequestDTO;
import com.arath.minierp.dto.EmployeeResponseDTO;
import com.arath.minierp.model.Employee;
import com.arath.minierp.service.EmployeeService;

@RestController
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<EmployeeResponseDTO> listarEmpleados(){
        return service.listarEmpleados();
    }
    
    @GetMapping("/employees/{id}")
    public Employee buscarEmpleadoporId(@PathVariable int id){

        return service.buscarEmpleadoPorId(id);
      
    }

 @PostMapping("/employees")
public Employee guardarEmpleado(@RequestBody EmployeeRequestDTO dto) {
    return service.guardarEmpleado(dto);
}
    @DeleteMapping("/employees/{id}")
    public Employee eliminarEmpleado(@PathVariable int id) {
        return service.eliminarEmpleado(id);
    }

    @PutMapping("/employees/{id}")
    public Employee actualizarEmpleado(@PathVariable int id,
        @RequestBody Employee empleado) {
         if (empleado.getId() != id) {
        throw new IllegalArgumentException("El id de la URL no coincide con el del cuerpo.");
    }
    return service.actualizarEmpleado(empleado);
    }
}
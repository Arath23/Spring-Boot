package com.arath.minierp.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Init;

import com.arath.minierp.dto.EmployeeResponseDTO;
import com.arath.minierp.service.EmployeeService;

public class EmployeeViewModel {

    private final EmployeeService service;

    private List<EmployeeResponseDTO> empleados;

    public EmployeeViewModel(EmployeeService service) {
        this.service = service;
    }

    @Init
    public void inicializar() {
        empleados = service.listarEmpleados();
    }

    public List<EmployeeResponseDTO> getEmpleados() {
        return empleados;
    }
}
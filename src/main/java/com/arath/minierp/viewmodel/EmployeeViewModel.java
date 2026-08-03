package com.arath.minierp.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Init;

import com.arath.minierp.config.SpringContext;
import com.arath.minierp.dto.EmployeeResponseDTO;
import com.arath.minierp.service.EmployeeService;

public class EmployeeViewModel {

    private EmployeeService employeeService;

    private List<EmployeeResponseDTO> empleados;

    @Init
    public void inicializar() {

        employeeService = SpringContext.getBean(EmployeeService.class);

        empleados = employeeService.listarEmpleados();
    }

    public List<EmployeeResponseDTO> getEmpleados() {
        return empleados;
    }
}
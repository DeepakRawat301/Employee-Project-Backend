package com.demo.emproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class EmpController
{

    //List<Employee> employees = new ArrayList<>();

    //EmployeeService employeeService = new EmployeeServiceImpl();

    //Dependency Injection
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees()
    {
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
        return employeeService.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee)
    {
         //employees.add(employee);
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        if(employeeService.deleteEmployee(id))
            return "Deleted Successfully";
        return "Not Found";
    }

    @PutMapping("employees/{id}")
    public String editEmployee(@PathVariable Long id, @RequestBody Employee employee)
    {
        return employeeService.updateEmployee(id, employee);
    }



}

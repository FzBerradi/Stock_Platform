package com.Tuto.Tuto;


import com.Tuto.Tuto.model.Employee;
import com.Tuto.Tuto.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee") // url qui va declencher un traitement dans ton controller
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee () {
        List<Employee>  employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
     @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        //extract attributes using url
         Employee employee = employeeService.findEmployeeById(id);
         return new ResponseEntity<>(employee, HttpStatus.OK);
     }

     @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        //take body json and convert it to java object
         Employee newEmployee = employeeService.addEmployee(employee);
         return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
     }
   @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
   }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>( HttpStatus.OK);
   }
}

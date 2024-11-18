package com.Tuto.Tuto.repositories;

import com.Tuto.Tuto.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JPA Repository is mainly used for managing the data in a Spring Boot Application
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}

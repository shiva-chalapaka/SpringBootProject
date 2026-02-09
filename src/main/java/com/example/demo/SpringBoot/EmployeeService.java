package com.example.demo.SpringBoot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        return repository.findById(id).map(emp -> {
            emp.setName(updatedEmployee.getName());
            emp.setDepartment(updatedEmployee.getDepartment());
            emp.setSalary(updatedEmployee.getSalary());
            return repository.save(emp);
        });
    }

    public boolean deleteEmployee(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

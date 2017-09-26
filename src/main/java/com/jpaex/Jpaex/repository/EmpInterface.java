package com.jpaex.Jpaex.repository;

import com.jpaex.Jpaex.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpInterface extends JpaRepository<Employee,Integer> {
    Employee findById(int id);

}

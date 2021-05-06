package com.crud.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.entity.Employee;


public interface EmpRepoCrud extends JpaRepository<Employee, Long>{

}

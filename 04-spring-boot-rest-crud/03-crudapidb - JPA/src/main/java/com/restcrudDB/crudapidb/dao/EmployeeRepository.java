package com.restcrudDB.crudapidb.dao;

import com.restcrudDB.crudapidb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}

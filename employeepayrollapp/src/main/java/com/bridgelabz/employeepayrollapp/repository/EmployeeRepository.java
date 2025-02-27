package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    @Query("SELECT e FROM EmployeeModel e WHERE e.department = ?1")
    List<EmployeeModel> findByDepartment(String department);

    @Query("SELECT e FROM EmployeeModel e WHERE e.department = 'Sales'")
    List<EmployeeModel> findSalesDepartmentEmployees();
}

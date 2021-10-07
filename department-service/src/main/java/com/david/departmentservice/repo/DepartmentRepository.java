package com.david.departmentservice.repo;

import com.david.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
//    public Department findByDeptId(Long id);
}

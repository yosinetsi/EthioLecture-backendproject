package com.example.EthioLecture.Repository;

import com.example.EthioLecture.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    void deleteBydepCode(String depCode);
    Department findBydepCode(String depCode);

}

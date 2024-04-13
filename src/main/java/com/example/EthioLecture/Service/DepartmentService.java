package com.example.EthioLecture.Service;

import com.example.EthioLecture.Entity.Department;
import com.example.EthioLecture.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public String postDepartment(Department department){
        departmentRepository.save(department);
        return "posted!";
    }

    public List<Department> getDepratment() {

        return  departmentRepository.findAll();
    }
    public Department getDepartementBydepCode(String depCode){
        return departmentRepository.findBydepCode(depCode);
    }

    public void deleteDepratment(Long id) {

        departmentRepository.deleteById(id);
    }
    public String  updateDepartment(String depCode ,Department department){
        Department exist=departmentRepository.findBydepCode(depCode);
        exist.setDepCode(depCode);;
        exist.setId(department.getId());
        exist.setDepTitle(department.getDepTitle());
        exist.setFaculty(department.getFaculty());
        departmentRepository.save(exist);
        return "updated!";
    }
}

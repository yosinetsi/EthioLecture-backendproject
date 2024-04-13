package com.example.EthioLecture.Repository;

import com.example.EthioLecture.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {


    Course findBycourseCode(String courseCode);
}

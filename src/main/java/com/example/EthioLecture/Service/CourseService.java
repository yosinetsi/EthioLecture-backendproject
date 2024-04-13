package com.example.EthioLecture.Service;

import com.example.EthioLecture.Entity.Course;
import com.example.EthioLecture.Repository.CourseRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/*
*
 */

@Service
public class CourseService {
    @Autowired
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public String postCourse(Course course) {
        courseRepository.save(course);
        return "posted !";

    }

    public void course(){

    }

    public List<Course> getCourse() {
        return  courseRepository.findAll();
    }

    public Optional<Course> getCourseByCourseCode(String courseCode) {
        return Optional.ofNullable(courseRepository.findBycourseCode(courseCode));
    }

    public void updateCourse(String courseCode, Course course) {
        Course exist=courseRepository.findBycourseCode(courseCode);
        exist.setCourseCode(courseCode);
        exist.setCourseTittle(course.getCourseTittle());
        exist.setId(course.getId());
        exist.setCatagory(course.getCatagory());
        courseRepository.save(exist);

    }
 public void deleteCourse(Long id){
        courseRepository.deleteById(id);
 }

}

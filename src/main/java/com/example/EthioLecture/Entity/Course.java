package com.example.EthioLecture.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true ,nullable = false)
    private  String courseCode;
    private String courseTittle;

    private String catagory;

    public Course() {
    }

    public Course(String courseCode, String courseTittle, String catagory) {
        this.courseCode = courseCode;
        this.courseTittle = courseTittle;
        this.catagory = catagory;
    }

    public Course(long id, String courseCode, String courseTittle, String catagory) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseTittle = courseTittle;
        this.catagory = catagory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTittle() {
        return courseTittle;
    }

    public void setCourseTittle(String courseTittle) {
        this.courseTittle = courseTittle;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", courseTittle='" + courseTittle + '\'' +
                ", catagory='" + catagory + '\'' +
                '}';
    }
}

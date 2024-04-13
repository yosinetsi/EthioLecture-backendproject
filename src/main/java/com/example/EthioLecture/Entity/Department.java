package com.example.EthioLecture.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true,nullable = false)
    private String depCode;
    private String depTitle;
    private String faculty;

    public Department() {
    }

    public Department(long id, String depCode, String depTitle, String faculty) {
        this.id = id;
        this.depCode = depCode;
        this.depTitle = depTitle;
        this.faculty = faculty;
    }

    public Department(String depCode, String depTitle, String faculty) {
        this.depCode = depCode;
        this.depTitle = depTitle;
        this.faculty = faculty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepTitle() {
        return depTitle;
    }

    public void setDepTitle(String depTitle) {
        this.depTitle = depTitle;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", depCode='" + depCode + '\'' +
                ", depTitle='" + depTitle + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}

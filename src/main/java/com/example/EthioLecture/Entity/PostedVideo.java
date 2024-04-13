package com.example.EthioLecture.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "posted_video")
public class PostedVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(unique = true,nullable = false)
    private String videoCode;

    @Column(nullable = false)
    private String depCode;
    @Column(nullable = false)

    private String  courseCode;
    @Column(nullable = false)
    private String postedOwner;

    private  String path;

    public PostedVideo() {
    }

    public PostedVideo(long id, String videoCode, String depCode, String courseCode, String postedOwner, String path) {
        this.id = id;
        this.videoCode = videoCode;
        this.depCode = depCode;
        this.courseCode = courseCode;
        this.postedOwner = postedOwner;
        this.path = path;
    }

    public PostedVideo(String videoCode, String depCode, String courseCode, String postedOwner, String path) {
        this.videoCode = videoCode;
        this.depCode = depCode;
        this.courseCode = courseCode;
        this.postedOwner = postedOwner;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostedOwner() {
        return postedOwner;
    }

    public void setPostedOwner(String postedOwner) {
        this.postedOwner = postedOwner;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "PostedVideo{" +
                "id=" + id +
                ", videoCode='" + videoCode + '\'' +
                ", depCode='" + depCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", postedOwner='" + postedOwner + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}

package com.example.EthioLecture.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="video_utility")
public class VideoUtility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userName;
    private String videoCode;
    private String comment;
    @Column(columnDefinition = "0")
    private int like;
    @Column(columnDefinition = "0")
    private int disLike;
    @Column(columnDefinition = "0")
    private int view ;

    public VideoUtility() {
    }

    public VideoUtility(long id, String userName, String videoCode, String comment, int like, int disLike, int view) {
        this.id = id;
        this.userName = userName;
        this.videoCode = videoCode;
        this.comment = comment;
        this.like = like;
        this.disLike = disLike;
        this.view = view;
    }

    public VideoUtility(String userName, String videoCode, String comment, int like, int disLike, int view) {
        this.userName = userName;
        this.videoCode = videoCode;
        this.comment = comment;
        this.like = like;
        this.disLike = disLike;
        this.view = view;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDisLike() {
        return disLike;
    }

    public void setDisLike(int disLike) {
        this.disLike = disLike;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "VideoUtility{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", videoCode='" + videoCode + '\'' +
                ", comment='" + comment + '\'' +
                ", like=" + like +
                ", disLike=" + disLike +
                ", view=" + view +
                '}';
    }





}

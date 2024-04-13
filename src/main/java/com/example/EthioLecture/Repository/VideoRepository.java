package com.example.EthioLecture.Repository;

import com.example.EthioLecture.Entity.PostedVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<PostedVideo,Long> {
    PostedVideo findByvideoCode(String videoCode);

}

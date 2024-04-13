package com.example.EthioLecture.Service;

import com.example.EthioLecture.Entity.PostedVideo;
import com.example.EthioLecture.Entity.VideoUtility;
import com.example.EthioLecture.Repository.VideoRepository;
import com.example.EthioLecture.Repository.VideoUtilityRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private final VideoRepository videoRepository;
    private final VideoUtilityRepository videoUtilityRepository;
    public VideoService(VideoRepository videoRepository, VideoUtilityRepository videoUtilityRepository) {
        this.videoRepository = videoRepository;
        this.videoUtilityRepository = videoUtilityRepository;
    }
    public String postVideo(PostedVideo postedVideo){
        videoRepository.save(postedVideo);

        return "posted!";
    }

    public List<PostedVideo> getAllVideo() {
        return  videoRepository.findAll();
    }

    public Optional<PostedVideo> getVideoByCode(String videoCode) {
        return Optional.ofNullable(videoRepository.findByvideoCode(videoCode));
    }

    public void updateVideo(String videoCode, PostedVideo video) {
        PostedVideo exist=videoRepository.findByvideoCode(videoCode);
        exist.setId(video.getId());
        exist.setVideoCode(videoCode);
        exist.setCourseCode(video.getCourseCode());
        exist.setPath(video.getPath());
        exist.setPostedOwner(video.getPostedOwner());
        exist.setDepCode(video.getDepCode());
        videoRepository.save(exist);
    }

    public void removeVideo(Long id) {

        videoRepository.deleteById(id);
    }

    /***
     *
     * @param userName
     * @param like
     */
    public void videoLike(String userName,int like){

    VideoUtility userVideo=videoUtilityRepository.findByuserName(userName);

      if(userVideo.getLike()==0 && userVideo.getDisLike()==0){
          userVideo.setLike(userVideo.getLike()+like);
          videoUtilityRepository.save(userVideo);
      }
      else if (userVideo.getLike()==1 && userVideo.getDisLike()==0){
          System.out.println("already u like it");

      }
      else if (userVideo.getLike()==0 && userVideo.getDisLike()==1){
          userVideo.setLike(userVideo.getLike()+like);
          userVideo.setDisLike(userVideo.getDisLike()-like);
         videoUtilityRepository.save(userVideo) ;
      }
      else {
          System.out.println("invalid command");
      }


    }


    public  void videoDisLike(String userName,int disLike){
        VideoUtility userVideo=videoUtilityRepository.findByuserName(userName);
        if(userVideo.getLike()==1  && userVideo.getDisLike()==0){
            userVideo.setLike(userVideo.getLike()-disLike);
            userVideo.setDisLike(userVideo.getDisLike()+1);
          videoUtilityRepository.save(userVideo);
        } else if (userVideo.getLike()==0 && userVideo.getDisLike()==0) {
            userVideo.setDisLike(userVideo.getDisLike()+disLike);
            videoUtilityRepository.save(userVideo);
        } else if (userVideo.getLike()==0 && userVideo.getDisLike()==1) {

            System.out.println("already u dis like");

        }
        else {

            System.out.println("invalid command");
        }
    }


 public void videoComment(String userName, String comment) {
        VideoUtility userVideo=videoUtilityRepository.findByuserName(userName);
        if(userVideo.getComment().isEmpty()){
            userVideo.setComment(comment);
            videoUtilityRepository.save(userVideo);
        }


 }





}

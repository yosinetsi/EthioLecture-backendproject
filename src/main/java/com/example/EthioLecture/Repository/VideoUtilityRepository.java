package com.example.EthioLecture.Repository;

import com.example.EthioLecture.Entity.VideoUtility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoUtilityRepository extends JpaRepository<VideoUtility,Long> {

    VideoUtility findByuserName(String userName);

}

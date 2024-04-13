package com.example.EthioLecture.Service;

import com.example.EthioLecture.Entity.UserAccount;
import com.example.EthioLecture.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /***
     *
     * @param userAccount
     * @return
     */

    public String postUser(UserAccount userAccount){
        userRepository.save(userAccount);
        return "posted user :"+userAccount.getUserName();
    }





}

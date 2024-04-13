package com.example.EthioLecture.Repository;

import com.example.EthioLecture.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount,Long> {
}

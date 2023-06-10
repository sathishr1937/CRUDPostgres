package com.crud.crud;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInforepository  extends JpaRepository<UserInfo,String>{

    UserInfo findById(UUID id);
    
}

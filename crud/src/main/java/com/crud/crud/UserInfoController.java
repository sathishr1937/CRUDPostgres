package com.crud.crud;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserInfoController {


    @Autowired 
    UserInforepository userInforepository;


    // get all employees
    @GetMapping()
    public List<UserInfo> getAllEmployees(){
        return userInforepository.findAll();
    }

    @PostMapping()
    public UserInfo creatUserInfo(@RequestBody UserInfo userInfo){
    //     BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    //    userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfo.setCreatedAt(LocalDateTime.now());
        userInfo.setUpdatedAt(LocalDateTime.now());
        System.out.println(userInfo);
        return userInforepository.save(userInfo);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserInfo> getUserInfoBYIDInfo(@PathVariable UUID id){
        UserInfo userInfo =  userInforepository.findById(id);
        return ResponseEntity.ok(userInfo);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserInfo> updateuserInfoEntity(@PathVariable UUID id, @RequestBody UserInfo userInfo){
     UserInfo user = userInforepository.findById(id);
     user.setName(userInfo.getName());
     user.setDob(userInfo.getDob());
     user.setEmail(userInfo.getEmail());
     user.setUpdatedAt(LocalDateTime.now());
     user.setAddress(userInfo.getAddress());
     user.setGen(userInfo.getGen());
     UserInfo updatedUserInfo = userInforepository.save(user);
     return ResponseEntity.ok(updatedUserInfo);
    }

    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<java.util.Map<String, Boolean>> deleteUserInfo(@PathVariable UUID id){
        UserInfo user = userInforepository.findById(id);
        userInforepository.delete(user);
        java.util.Map<String,Boolean> map = new HashMap<>();
        map.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(map);

    
    }


    
}

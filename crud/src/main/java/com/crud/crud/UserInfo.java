package com.crud.crud;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UserInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
   @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
   @Column(name =  "name")
   private  String name;
   @Column(name =  "email")
   private String email;
   @Column(name =  "dob")
   private Date dob;
   @Column(name =  "createdAt")
   private LocalDateTime createdAt;
   @Column(name =  "updatedAt")
   private LocalDateTime updatedAt;
   @Column(name =  "address")
   private String address;
   private enum gender {male,female};
   @Enumerated(EnumType.ORDINAL)
   private gender gen;
   @Column(name = "password")
   private String password;

    
}

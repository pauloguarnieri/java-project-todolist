package io.github.pauloguarnieri.todolist.user;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
// import lombok.Getter;
import jakarta.persistence.Id;

@Data
@Entity(name="tb_users")
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    
    // especifico para cada atributo
    // @Getter  
    // @Setter
    // private String username;  //o getter e setter só estão no escopo para esse atributo
    // private String name;
    // @Setter
    // private String password; // o setter esta no escopo deste atributo

    
    //getters setters
    
    // public void setUsername(String username) {
    //     this.username = username;
    // }

    // public String getUsername() {
    //     return username;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public String getPassword() {
    //     return password;
    // } 

}
 
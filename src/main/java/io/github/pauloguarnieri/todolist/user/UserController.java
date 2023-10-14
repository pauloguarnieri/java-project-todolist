package io.github.pauloguarnieri.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private IUserRepository userRepository;

    // Body da requisição
    @PostMapping("/")
    //define que o que vai receber é o user body
    // public UserModel create(@RequestBody UserModel userModel ){
    public ResponseEntity create(@RequestBody UserModel userModel ){
        // System.out.println(userModel.getUsername());
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null){
            System.out.println("usuario já cadastrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario já cadastrado");
        }

        var passwordHashed = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashed);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    };

    @GetMapping("/")
    public void list(){
        System.out.println("metodo get");
    };

    @PutMapping("/")
    public void update(){
        System.out.println("metodo put");
    };
    
    @PatchMapping("/")
    public void edit(){
        System.out.println("metodo patch");
    }

    @DeleteMapping("/")
    public void delete(){
        System.out.println("Metodo delete");
    }

}

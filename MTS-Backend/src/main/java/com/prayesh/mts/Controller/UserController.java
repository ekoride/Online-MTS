package com.prayesh.mts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prayesh.mts.Advice.UserNotFoundException;
import com.prayesh.mts.RequestHandlers.LoginUser;
import com.prayesh.mts.Service.UserService;
import com.prayesh.mts.entity.user;

import jakarta.validation.Valid;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;




    
    // @PostMapping("/userLogin")
    // public user SignIn(@RequestBody LoginUser user1) throws ResourceNotFoundException, Exception{
    //     return userService.checkUser(user1.getEmail(), user1.getPassword());
    // }
    
    @PostMapping("/userLogin")
    public user signIn(@RequestBody LoginUser authenticateUser) throws UserNotFoundException{
        return userService.checkUser(authenticateUser.getEmail(), authenticateUser.getPassword());
    }

















    @GetMapping("/getUsers")
    public ResponseEntity<List<user>> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
    
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<user> getUserById(@PathVariable("id") long id) throws UserNotFoundException{
        return ResponseEntity.ok(userService.findUserById(id));
    }
    

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<user> getUserByEmail(@PathVariable("email") String email) throws UserNotFoundException{
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
        
    }

    @GetMapping("/getUserByPhone/{phone}")
    public ResponseEntity<user> getUserByPhone(@PathVariable("phone") String phone) throws UserNotFoundException{
        return new ResponseEntity<>(userService.findUserByPhone(phone), HttpStatus.OK);
    } 

    // User SignUp 
    @PostMapping("/userSignUp")
    public ResponseEntity<user> saveUser(@RequestBody @Valid user userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    } 
}





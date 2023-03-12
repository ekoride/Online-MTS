package com.prayesh.mts.Service;

import java.util.List;

import com.prayesh.mts.Advice.UserNotFoundException;
import com.prayesh.mts.entity.user;

import jakarta.validation.Valid;

public interface UserService {
    //public user checkUser(String uname, String password) throws ResourceNotFoundException, Exception;

    public user checkUser(String email, String password) throws UserNotFoundException;
    













    public List<user> findAll();
    
    public user saveUser(@Valid user userRequest);

    public user findUserByEmail(String email) throws UserNotFoundException;

    public user findUserByPhone(String phone) throws UserNotFoundException;

    public user findUserById(long id) throws UserNotFoundException;







    

}

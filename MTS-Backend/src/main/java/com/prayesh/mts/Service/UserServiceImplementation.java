package com.prayesh.mts.Service;


import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prayesh.mts.Advice.DBException;
import com.prayesh.mts.Advice.SystemException;
import com.prayesh.mts.Advice.UserNotFoundException;

import com.prayesh.mts.Repository.UserRepository;
import com.prayesh.mts.entity.user;

import jakarta.validation.Valid;

@Service
public class UserServiceImplementation implements UserService{
    
    @Autowired
    private UserRepository userRepository;




    
    // @Override
    // public user checkUser(String uname, String pass) throws ResourceNotFoundException, Exception{
    //     try{
    //         Optional<user> user1 = userRepository.checkUserAndPass(uname, pass);
    //         if(!user1.isPresent()){
    //             throw new ResourceNotFoundException("User Not Found");
    //         }
    //         return user1.get();
    //     }
    //     // catch(ResourceNotFoundException exception){
    //     //     throw new ResourceNotFoundException("User not found");
    //     // }
    //     catch(Exception exception){
    //         throw new DBException("Internal Server Error");
    //     }
        
    // }


    @Override
    public user checkUser(String email, String password) throws UserNotFoundException {
        user authenticateUser = null;
        try{
            authenticateUser = userRepository.checkUserAndPass(email, password);
            if(authenticateUser==null){
                user validateEmail = userRepository.findByUserEmailId(email);
                if(validateEmail!=null){
                    throw new UserNotFoundException("Incorrect password please enter again!");
                }else{
                    throw new UserNotFoundException("User not found with email: "+ email);
                }
            }
        }catch(UserNotFoundException ex){
            throw new UserNotFoundException(ex.getMessage());
        }catch(Exception ex){
            throw new SystemException(ex.getMessage());
        }
        return authenticateUser;
    }




    













    
    @Override
    public  user saveUser(@Valid user requestUser){
        user responseUser = null;
        try{
            responseUser =  userRepository.save(requestUser);
        }catch(HibernateException ex){
            throw new DBException(ex.getMessage());
        }catch(Exception ex){
            throw new SystemException(ex.getMessage());
        }
        return responseUser;
    }

    @Override
    public List<user> findAll() {
        return userRepository.findAll();
    }


    @Override
    public user findUserById(long id) throws UserNotFoundException{
        user requestUser = userRepository.findByUserId(id);
        if(requestUser!=null){
            return requestUser;
        }else{
            throw new UserNotFoundException("User not found with id: "+ id);
        }
    }

    @Override
    public user findUserByEmail(String email) throws UserNotFoundException {
        user requestUser = userRepository.findByUserEmailId(email);
        if(requestUser!=null){
            return requestUser;
        }else{
            throw new UserNotFoundException("User not found with email: "+email);
        }
    }

    @Override
    public user findUserByPhone(String phone) throws UserNotFoundException{
        user requestUser = userRepository.findByUserPhone(phone);
        if(requestUser!=null){
            return requestUser;
        }else{
            throw new UserNotFoundException("User not found with phone: "+phone);
        }
    }

    



}




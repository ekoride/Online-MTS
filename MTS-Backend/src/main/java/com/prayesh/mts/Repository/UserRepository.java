package com.prayesh.mts.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prayesh.mts.entity.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long>{

    @Query(value = "select * from user u where u.user_email_id=?1 and u.user_password=?2", nativeQuery = true)
    public user checkUserAndPass(String uname, String password);











    
    public user findByUserEmailId(String email);


    public user findByUserPhone(String phone);


    public user findByUserId(long id);   
}

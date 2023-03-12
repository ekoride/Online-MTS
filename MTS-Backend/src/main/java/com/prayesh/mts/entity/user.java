package com.prayesh.mts.entity;

import java.sql.Date;



import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "User",
        uniqueConstraints = {@UniqueConstraint(
            columnNames = {"user_phone","user_email_id"}
        )}
)
public class user {

    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        initialValue = 1000,
        allocationSize = 1
    )
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    
    )
    private long userId;

    @NotBlank(message = "Password cannot be empty!")
    @Column(name = "user_password")
    private String user_password;
    
    
    @Column(name = "user_name")
    private String userName;
    
    
    @Column(name = "user_email_id", unique = true)
    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Invalid email format")
    private String userEmailId;
    
    
    @NotBlank(message = "Address cannot be empty")
    @Column(name = "user_address")
    private String userAddress;
    
    
    @NotBlank(message = "Phone cannot be blank!")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered!")
    @Column(name = "user_phone", unique = true)
    private String userPhone;
    
    
    @NotNull(message = "User must enter data of birth")
    @Past(message = "Date of birth cannot be from future!")
    @Column(name = "user_dob")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date userDOB;


    @Column(name = "is_UserAdmin")
    private boolean isUserAdmin;

}

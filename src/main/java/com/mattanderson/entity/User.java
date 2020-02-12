package com.mattanderson.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity(name = "User")
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_role_id")
    private int userRoleId; //Should I create user role if there isn't any distinction at this point? Should it be an object?



}

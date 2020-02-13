package com.mattanderson.carbConscious.entity;

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
    //@Column(name = "user_role_id")
    //private List<UserRole> userRoles; //Touched base with Paula -- likely need this to be a list of objects -- comment out for Exercise 4



}

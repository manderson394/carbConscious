package com.mattanderson.carbConscious.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Defines a User object to represent a registered user.
 *
 * @author Matt Anderson
 * @version 11
 */
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
    @Column(name = "password")
    private String password;
    //@Column(name = "user_role_id")
    //private List<UserRole> userRoles; //Touched base with Paula -- likely need this to be a list of objects -- comment out for Exercise 4
    @Column(name = "creation_datetime")
    private LocalDateTime creationDateTime;
    @Column(name = "update_datetime")
    private LocalDateTime updateDateTime;


    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Instantiates a new User.
     *
     * @param firstName        the first name
     * @param lastName         the last name
     * @param userName         the user name
     * @param password         the password
     * @param creationDateTime the creation date time
     * @param updateDateTime   the update date time
     */
    public User(String firstName, String lastName, String userName, String password, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
    }

    /**
     * Instantiates a new User.
     *
     * @param id               the id
     * @param firstName        the first name
     * @param lastName         the last name
     * @param userName         the user name
     * @param password         the password
     * @param creationDateTime the creation date time
     * @param updateDateTime   the update date time
     */
    public User(int id, String firstName, String lastName, String userName, String password, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets creation date time.
     *
     * @return the creation date time
     */
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Sets creation date time.
     *
     * @param creationDateTime the creation date time
     */
    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    /**
     * Gets update date time.
     *
     * @return the update date time
     */
    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    /**
     * Sets update date time.
     *
     * @param updateDateTime the update date time
     */
    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}

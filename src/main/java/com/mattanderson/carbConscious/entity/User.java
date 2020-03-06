package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Defines a User object to represent a registered user.
 *
 * @author Matt Anderson
 * @version 11
 */
@Entity(name = "User")
@Table(name = "USERS")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    @NotNull
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @Column(name = "update_datetime")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserRole> roles;

    //TODO finish links to User class
    //private Set<UserFavorites> favorites;

    //private Set<CarbohydratesEstimate> estimates;

    /**
     * Instantiates a new User.
     */
    public User() {
        roles = new HashSet<>();
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName        the first name
     * @param lastName         the last name
     * @param userName        the user name
     * @param email            the user email
     * @param password         the password
     * @param creationDateTime the creation date time
     * @param updateDateTime   the update date time
     */
    public User(String firstName, String lastName, String userName, String email, String password, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
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
     * @param userName        the user name
     * @param email            the user email
     * @param password         the password
     * @param creationDateTime the creation date time
     * @param updateDateTime   the update date time
     */
    public User(int id, String firstName, String lastName, String userName, String email, String password, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName        the first name
     * @param lastName         the last name
     * @param userName        the user name
     * @param email            the user email
     * @param password         the password
     * @param creationDateTime the creation date time
     * @param updateDateTime   the update date time
     * @param roles            the roles
     */
    public User(String firstName, String lastName, String userName, String email, String password, LocalDateTime creationDateTime, LocalDateTime updateDateTime, Set<UserRole> roles) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
        this.roles = roles;
    }

    /**
     * Instantiates a new User.
     *
     * @param id               the id
     * @param firstName        the first name
     * @param lastName         the last name
     * @param userName        the user name
     * @param email            the user email
     * @param password         the password
     * @param creationDateTime the creation date time
     * @param updateDateTime   the update date time
     * @param roles            the roles
     */
    public User(int id, String firstName, String lastName, String userName, String email, String password, LocalDateTime creationDateTime, LocalDateTime updateDateTime, Set<UserRole> roles) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
        this.roles = roles;
    }

    /**
     * Add role.
     *
     * @param role the role
     */
    public void addRole(UserRole role) {
        roles.add(role);
    }

    /**
     * Remove role.
     *
     * @param role the role
     */
    public void removeRole(UserRole role) {
        roles.remove(role);
        role.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(creationDateTime, user.creationDateTime) &&
                Objects.equals(updateDateTime, user.updateDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, email, password, creationDateTime, updateDateTime);
    }
}

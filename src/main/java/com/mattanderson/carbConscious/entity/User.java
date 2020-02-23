package com.mattanderson.carbConscious.entity;

import org.hibernate.annotations.GenericGenerator;
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
    private LocalDateTime creationDateTime;

    @Column(name = "update_datetime")
    private LocalDateTime updateDateTime;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserRole> roles;

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
     * @return the user names
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user names
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets user email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public Set<UserRole> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<UserRole> roles) {
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

package com.mattanderson.carbConscious.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @NotNull
    private Set<String> userNames;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "creation_datetime")
    private LocalDateTime creationDateTime;

    @Column(name = "update_datetime")
    private LocalDateTime updateDateTime;

    /**
     * Instantiates a new User.
     */
    public User() {
        userNames = new HashSet<>();
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName        the first name
     * @param lastName         the last name
     * @param userNames        the user names
     * @param email            the user email
     * @param password         the password
     * @param creationDateTime the creation date time
     * @param updateDateTime   the update date time
     */
    public User(String firstName, String lastName, Set<String> userNames, String email,String password, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNames = userNames;
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
     * @param userNames        the user names
     * @param email            the user email
     * @param password         the password
     * @param creationDateTime the creation date time
     * @param updateDateTime   the update date time
     */
    public User(int id, String firstName, String lastName, Set<String> userNames, String email, String password, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNames = userNames;
        this.email = email;
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
     * @return the user names
     */
    public Set<String> getUserNames() {
        return userNames;
    }

    /**
     * Sets user name.
     *
     * @param userNames the user names
     */
    public void setUserNames(Set<String> userNames) {
        this.userNames = userNames;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userNames + '\'' +
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
                Objects.equals(userNames, user.userNames) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(creationDateTime, user.creationDateTime) &&
                Objects.equals(updateDateTime, user.updateDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userNames, email, password, creationDateTime, updateDateTime);
    }
}

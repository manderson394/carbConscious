package com.mattanderson.carbConscious.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Defines roles for members of the <code>User</code> class to help define access.
 * @author Matt Anderson
 * @version 11
 */
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String name;

    @ManyToOne
    private String userName;

    @Column(name = "creation_datetime")
    private LocalDateTime creationDateTime;


    /**
     * Instantiates a new User role.
     */
    public UserRole() {

    }

    /**
     * Instantiates a new User role.
     *
     * @param name             the name
     * @param userName         the user name
     * @param creationDateTime the creation date time
     */
    public UserRole(String name, String userName, LocalDateTime creationDateTime) {
        this();
        this.name = name;
        this.userName = userName;
        this.creationDateTime = creationDateTime;
    }

    /**
     * Instantiates a new User role.
     *
     * @param id               the id
     * @param name             the name
     * @param userName         the user name
     * @param creationDateTime the creation date time
     */
    public UserRole(int id, String name, String userName, LocalDateTime creationDateTime) {
        this();
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.creationDateTime = creationDateTime;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", creationDateTime=" + creationDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                Objects.equals(name, userRole.name) &&
                Objects.equals(userName, userRole.userName) &&
                Objects.equals(creationDateTime, userRole.creationDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userName, creationDateTime);
    }
}

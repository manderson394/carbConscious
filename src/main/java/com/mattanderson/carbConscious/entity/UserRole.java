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
@Entity(name = "UserRole")
@Table(name = "USER_ROLES")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String name;

    @Column(name = "creation_datetime")
    private LocalDateTime creationDateTime;

    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    private User user;


    /**
     * Instantiates a new User role.
     */
    public UserRole() {

    }

    /**
     * Instantiates a new User role.
     *
     * @param name             the name
     * @param creationDateTime the creation date time
     * @param user             the user
     */
    public UserRole(String name, LocalDateTime creationDateTime, User user) {
        this();
        this.name = name;
        this.creationDateTime = creationDateTime;
        this.user = user;
    }

    /**
     * Instantiates a new User role.
     *
     * @param id               the id
     * @param name             the name
     * @param creationDateTime the creation date time
     * @param user             the user
     */
    public UserRole(int id, String name, LocalDateTime creationDateTime, User user) {
        this();
        this.id = id;
        this.name = name;
        this.creationDateTime = creationDateTime;
        this.user = user;
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
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                Objects.equals(name, userRole.name) &&
                Objects.equals(creationDateTime, userRole.creationDateTime) &&
                Objects.equals(user, userRole.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDateTime, user);
    }
}

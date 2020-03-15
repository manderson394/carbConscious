package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
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
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String name;

    @Column(name = "creation_datetime")
    @CreationTimestamp
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                Objects.equals(name, userRole.name) &&
                Objects.equals(user, userRole.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, user);
    }
}

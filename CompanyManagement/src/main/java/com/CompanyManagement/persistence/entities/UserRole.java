package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(length = 20, nullable = false, unique = true)
    String roleName;

    public UserRole() {
    }

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

}
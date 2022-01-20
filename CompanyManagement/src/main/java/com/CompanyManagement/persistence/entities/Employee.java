package com.CompanyManagement.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(length = 35, nullable = false)
    String employeeName;

    @Column(length = 35, nullable = false)
    String surname;

    @Column(length = 11, nullable = false, unique = true)
    long oib;

    @Column(length = 50)
    String address;

    @Column(unique = true)
    String email;

    @Column()
    String passwd;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection< UserRole > roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Invoice> invoices;

    public Employee() {
    }

    public Employee(String employeeName, String surname, long oib, String address, String email, String passwd, Collection<UserRole> roles) {
        this.employeeName = employeeName;
        this.surname = surname;
        this.oib = oib;
        this.address = address;
        this.email = email;
        this.passwd = passwd;
        this.roles = roles;
    }

}

package com.example.demo;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal salary;

    protected Employee() {}

    public Employee(String name, String email, BigDecimal salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Employee setName(String name) { this.name = name; return this; }
    public String getEmail() { return email; }
    public Employee setEmail(String email) { this.email = email; return this; }
    public BigDecimal getSalary() { return salary; }
    public Employee setSalary(BigDecimal salary) { this.salary = salary; return this; }
}

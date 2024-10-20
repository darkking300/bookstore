package com.bookstore.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

@Data
@Entity
@Table(name = "customers", uniqueConstraints = {@UniqueConstraint(columnNames = {"userId","id"})})
public class Customers {

    private String userId;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}

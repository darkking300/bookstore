package com.bookstore.bookstore.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Component;


@Entity
@Data
@Table(name="book", uniqueConstraints = {@UniqueConstraint(columnNames = {"bookId"})})
@Transactional
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long bookId;
    private String isbnNumber;
    private String bookName;
    private String genre;
    private Double price;
}

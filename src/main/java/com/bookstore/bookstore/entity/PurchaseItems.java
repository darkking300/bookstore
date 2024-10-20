package com.bookstore.bookstore.entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class PurchaseItems {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uniqueId;

    private long bookId;
}

package com.bookstore.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="inventory")
public class BookInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventoryId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_book_id")
    private Book book;

    private long numberOfBooks;
}

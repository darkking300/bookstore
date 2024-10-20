package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.BookInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<BookInventory, Long> {
}

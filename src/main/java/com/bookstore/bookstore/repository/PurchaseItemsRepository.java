package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.PurchaseItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemsRepository extends JpaRepository<PurchaseItems, Long> {
}

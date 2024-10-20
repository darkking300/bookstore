package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.entity.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasesRepository extends JpaRepository<Purchases, Long> {
}

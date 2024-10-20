package com.bookstore.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "purchases", uniqueConstraints = {@UniqueConstraint(columnNames = {"orderId"})})
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;

    private Timestamp timeOfPurchase;
    private Double transactionAmount;

    private String userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id", referencedColumnName = "orderId")
    private List<PurchaseItems> purchaseItems;
}

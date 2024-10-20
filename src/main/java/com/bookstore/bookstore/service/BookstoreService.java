package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.PurchaseOrder;
import com.bookstore.bookstore.entity.*;

import java.util.List;

public interface BookstoreService {
    public List<BookInventory> listEntireInventory();

    public List<Book> getBooksByGenre();

    public boolean purchaseBooks(PurchaseOrder purchaseOrder);

    public boolean addBooks(BookInventory inventoryItem);

    //TODO: more for borrowing books,deleting/removing books and returning books
}

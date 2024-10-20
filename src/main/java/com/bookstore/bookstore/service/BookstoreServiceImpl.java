package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.PurchaseOrder;
import com.bookstore.bookstore.entity.*;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.InventoryRepo;
import com.bookstore.bookstore.repository.PurchasesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookstoreServiceImpl implements BookstoreService{

    private static final Logger log = LoggerFactory.getLogger(BookstoreServiceImpl.class);
    @Autowired
    InventoryRepo inventoryRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PurchasesRepository purchasesRepository;

    @Override
    public List<BookInventory> listEntireInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public List<Book> getBooksByGenre() {
        return List.of();
    }

    @Override
    public boolean purchaseBooks(PurchaseOrder purchaseOrder) {

        Double amt = 0.0;
        if(null == purchaseOrder.getBookIdList()){
            return false;
        }
        List<Book> bookList = bookRepository.findBybookIdIn(purchaseOrder.getBookIdList());
        List<PurchaseItems> purchaseItems = new ArrayList<>();

        if(null != bookList && !bookList.isEmpty()){
            Map<Long,Double> bookPrices = new HashMap<>();
            bookPrices = bookList.stream().collect(Collectors.toMap(Book::getBookId, Book::getPrice));
            if(!bookPrices.isEmpty()){
                for(Long bookId : purchaseOrder.getBookIdList()){
                    amt += bookPrices.get(bookId);
                    PurchaseItems tempItem = new PurchaseItems();
                    tempItem.setBookId(bookId);
                    purchaseItems.add(tempItem);
                }
            }
        }

        Purchases purchases = new Purchases();
        purchases.setTimeOfPurchase(new Timestamp(System.currentTimeMillis()));
        purchases.setUserId(purchaseOrder.getUserId());
        purchases.setTransactionAmount(amt);
        purchases.setPurchaseItems(purchaseItems);

        purchasesRepository.save(purchases);

        return true;
    }

    @Override
    public boolean addBooks(BookInventory inventoryItem) {
        try{
            Book newBook = inventoryItem.getBook();
            System.out.println();
            bookRepository.save(newBook);
            inventoryRepository.save(inventoryItem);
            return true;
        }catch(Exception e){
            log.error("Exception occurred during adding books");
            log.error(e.getMessage());
        }
        return false;
    }
}

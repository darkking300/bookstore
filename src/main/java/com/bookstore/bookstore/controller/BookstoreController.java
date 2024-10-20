package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.PurchaseOrder;
import com.bookstore.bookstore.entity.BookInventory;
import com.bookstore.bookstore.service.BookstoreServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/api/v1")
public class BookstoreController {

    @Autowired
    BookstoreServiceImpl bookstoreService;

    @Autowired
    Environment environment;

    @GetMapping(value = "/instance", produces = "application/json")
    public ResponseEntity<String> getInstance(){
        return new ResponseEntity<>(environment.getProperty("instance-id"),HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<BookInventory>> getAllBooks(){
        return new ResponseEntity<>(bookstoreService.listEntireInventory(),
                HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addBooks(@RequestBody BookInventory bookInventory){
        bookstoreService.addBooks(bookInventory);
        return new ResponseEntity<>("Data added successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/purchase", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> purchaseBooks(@RequestBody PurchaseOrder purchaseOrder){
        try{
            bookstoreService.purchaseBooks(purchaseOrder);
            return new ResponseEntity<>("Data added successfully", HttpStatus.ACCEPTED);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>("Data added successfully", HttpStatus.ACCEPTED);
        }

    }
}

package com.bookstore.bookstore.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@Data
public class PurchaseOrder {
    private List<Long> bookIdList;
    private String userId;
}

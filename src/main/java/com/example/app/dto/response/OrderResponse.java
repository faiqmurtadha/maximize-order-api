package com.example.app.dto.response;

import java.util.List;

import com.example.app.model.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    
    private List<Item> itemsName;
    private Double totalOrder;
}

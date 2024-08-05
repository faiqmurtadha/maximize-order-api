package com.example.app.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.app.dto.request.CreateOrderRequest;
import com.example.app.dto.response.OrderResponse;
import com.example.app.model.Item;
import com.example.app.repository.ItemRepository;

@Service
public class OrderService {
    
    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<OrderResponse> calculate(CreateOrderRequest request) {
        List<Item> items = itemRepository.findAll().stream().sorted(
            Comparator.comparingDouble(Item::getPrice).reversed()
        ).collect(Collectors.toList());

        Double maxShopAmount = 0.0;
        List<Item> itemsName = new ArrayList<>();
        int index = 0;
        Double nominal = request.getNominal();
        do {
            if (items.get(index).getPrice() <= nominal) {
                itemsName.add(items.get(index));
                maxShopAmount += items.get(index).getPrice();
                nominal -= items.get(index).getPrice();
                index++;
            } else {
                index++;
            }
        } while (maxShopAmount <= request.getNominal() && index <= items.size()-1 );

        OrderResponse response = new OrderResponse(itemsName, maxShopAmount);

        return ResponseEntity
            .ok()
            .body(response);
    }
}

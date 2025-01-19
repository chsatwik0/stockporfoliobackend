package com.backendproject.addstockstodb.controller;

import com.backendproject.addstockstodb.model.stock;
import com.backendproject.addstockstodb.service.stockservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:3000")
public class stockcontroller {

    @Autowired
    private stockservice stockService;

    @GetMapping
    public List<stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Optional<stock> getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PostMapping
    public stock addStock(@RequestBody stock stock) {
        return stockService.addStock(stock);
    }

    @PutMapping("/{id}")
    public stock updateStock(@PathVariable Long id, @RequestBody stock stock) {
        return stockService.updateStock(id, stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}


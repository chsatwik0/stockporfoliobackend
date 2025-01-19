package com.backendproject.addstockstodb.service;

import com.backendproject.addstockstodb.model.stock;
import com.backendproject.addstockstodb.repository.stockrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class stockservice {

    @Autowired
    private stockrepository stockRepository;

    public List<stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    public stock addStock(stock stock) {
        return stockRepository.save(stock);
    }

    public stock updateStock(Long id, stock stockDetails) {
        stock stock = stockRepository.findById(id).orElseThrow();
        stock.setStockName(stockDetails.getStockName());
        stock.setTicker(stockDetails.getTicker());
        stock.setQuantity(stockDetails.getQuantity());
        stock.setBuyPrice(stockDetails.getBuyPrice());
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}


package com.backendproject.addstockstodb.repository;

import com.backendproject.addstockstodb.model.stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface stockrepository extends JpaRepository<stock, Long> {
}

package com.example.currencyexchange.repository;

import com.example.currencyexchange.model.ExchangeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeModelRepository extends JpaRepository<ExchangeModel, Long> {
    ExchangeModel findByName(String name);

    boolean existsByName(String name);
}

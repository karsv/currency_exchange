package com.example.currency_exchange.repository;

import com.example.currency_exchange.model.ExchangeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeModelRepository extends JpaRepository<ExchangeModel, Long> {
}

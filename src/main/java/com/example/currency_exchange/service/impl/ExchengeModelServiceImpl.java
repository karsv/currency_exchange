package com.example.currency_exchange.service.impl;

import com.example.currency_exchange.model.ExchangeModel;
import com.example.currency_exchange.repository.ExchangeModelRepository;
import com.example.currency_exchange.service.ExchangeModelService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExchengeModelServiceImpl implements ExchangeModelService {
    private final ExchangeModelRepository exchangeModelRepository;

    public ExchengeModelServiceImpl(ExchangeModelRepository exchangeModelRepository) {
        this.exchangeModelRepository = exchangeModelRepository;
    }

    @Override
    public List<ExchangeModel> saveAll(List<ExchangeModel> models) {
        return exchangeModelRepository.saveAll(models);
    }

    @Override
    public List<ExchangeModel> getAll() {
        return exchangeModelRepository.findAll();
    }
}

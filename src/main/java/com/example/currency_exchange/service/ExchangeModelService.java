package com.example.currency_exchange.service;

import com.example.currency_exchange.model.ExchangeModel;
import java.util.List;

public interface ExchangeModelService {
    List<ExchangeModel> saveAll(List<ExchangeModel> models);

    List<ExchangeModel> getAll();
}

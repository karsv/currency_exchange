package com.example.currencyexchange.service;

import com.example.currencyexchange.model.ExchangeModel;
import java.util.List;

public interface ExchangeModelService {
    List<ExchangeModel> saveAll(List<ExchangeModel> models);

    List<ExchangeModel> getAll();
}

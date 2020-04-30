package com.example.currencyexchange.service.impl;

import com.example.currencyexchange.model.ExchangeModel;
import com.example.currencyexchange.repository.ExchangeModelRepository;
import com.example.currencyexchange.service.ExchangeModelService;
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
    public ExchangeModel save(ExchangeModel exchangeModel) {
        if (exchangeModelRepository.existsByName(exchangeModel.getName())) {
            exchangeModel.setId(exchangeModelRepository.
                    findByName(exchangeModel.getName()).getId());
        }
        return exchangeModelRepository.save(exchangeModel);
    }

    @Override
    public List<ExchangeModel> getAll() {
        return exchangeModelRepository.findAll();
    }
}

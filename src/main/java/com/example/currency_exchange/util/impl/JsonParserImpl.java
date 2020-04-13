package com.example.currency_exchange.util.impl;

import com.example.currency_exchange.dto.ExchangeJsonDto;
import com.example.currency_exchange.exceptions.DataException;
import com.example.currency_exchange.model.ExchangeModel;
import com.example.currency_exchange.util.JsonParser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonParserImpl implements JsonParser {
    @Override
    public List<ExchangeModel> getExchangeModels(String json) {
        ObjectMapper obj = new ObjectMapper();
        try {
            return convertFromDtoToModel(obj.readValue(json, new TypeReference<ArrayList<ExchangeJsonDto>>() {
            }));
        } catch (JsonProcessingException e) {
            throw new DataException("Exception while parse JSON", e);
        }
    }

    private List<ExchangeModel> convertFromDtoToModel(List<ExchangeJsonDto> list) {
        return list.stream().map(dto -> {
            ExchangeModel exchangeModel = new ExchangeModel();
            exchangeModel.setName(dto.getCcy());
            exchangeModel.setBase(dto.getBase_ccy());
            exchangeModel.setSale(dto.getSale());
            exchangeModel.setBuy(dto.getBuy());
            return exchangeModel;
        }).collect(Collectors.toList());
    }
}

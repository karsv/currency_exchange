package com.example.currency_exchange.util;

import com.example.currency_exchange.model.ExchangeModel;
import java.util.List;

public interface JsonParser {
    List<ExchangeModel> getExchangeModels(String json);
}

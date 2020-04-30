package com.example.currencyexchange.util;

import com.example.currencyexchange.model.ExchangeModel;
import java.util.List;

public interface JsonParser {
    List<ExchangeModel> getExchangeModels(String json);
}

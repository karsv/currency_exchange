package com.example.currencyexchange.controllers;

import com.example.currencyexchange.exceptions.DataException;
import com.example.currencyexchange.model.ExchangeModel;
import com.example.currencyexchange.service.ExchangeModelService;
import com.example.currencyexchange.util.CustomHttpConnection;
import com.example.currencyexchange.util.JsonParser;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exchange")
public class ExchangeController {
    private final ExchangeModelService exchangeModelService;
    private final CustomHttpConnection customHttpConnection;
    private final JsonParser jsonParser;

    @Value("${exchange.private.url}")
    private String url;

    public ExchangeController(ExchangeModelService exchangeModelService,
                              CustomHttpConnection customHttpConnection,
                              JsonParser jsonParser) {
        this.exchangeModelService = exchangeModelService;
        this.customHttpConnection = customHttpConnection;
        this.jsonParser = jsonParser;
    }

    @GetMapping("/get")
    public String getExchange(Model model) {
        for(ExchangeModel exchangeModel : getExchangeFromUrl(url)){
            exchangeModelService.save(exchangeModel);
        }
//        exchangeModelService.saveAll(getExchangeFromUrl(url));
        model.addAttribute("exchanges", exchangeModelService.getAll());
        return "exchanges";
    }

    private List<ExchangeModel> getExchangeFromUrl(String url) {
        try {
            return jsonParser.getExchangeModels(customHttpConnection.sendGet(url));
        } catch (IOException e) {
            throw new DataException("Http connection exception!", e);
        }
    }
}

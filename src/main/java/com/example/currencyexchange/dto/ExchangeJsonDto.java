package com.example.currencyexchange.dto;

import lombok.Data;

@Data
public class ExchangeJsonDto {
    private String ccy;
    private String baseCcy;
    private Double buy;
    private Double sale;
}

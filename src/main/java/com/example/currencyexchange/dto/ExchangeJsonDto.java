package com.example.currencyexchange.dto;

import lombok.Data;

@Data
public class ExchangeJsonDto {
    private String ccy;
    private String base_ccy;
    private Double buy;
    private Double sale;
}

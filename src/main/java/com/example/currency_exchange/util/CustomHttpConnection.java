package com.example.currency_exchange.util;

import java.io.IOException;

public interface CustomHttpConnection {
    String sendGet(String url) throws IOException;
}

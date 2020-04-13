package com.example.currencyexchange.util;

import java.io.IOException;

public interface CustomHttpConnection {
    String sendGet(String url) throws IOException;
}

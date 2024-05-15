package com.aluracursos.challenge_currency_conversion.models;

import java.time.LocalDateTime;

public record ConversionRecord(String baseCurrency, String targetCurrency, double initialValue, double convertedValue,
                               LocalDateTime dateTime) {

}

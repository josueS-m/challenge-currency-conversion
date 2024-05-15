package com.aluracursos.challenge_currency_conversion.models;

public record CurrencyConverter(String base_code,
                                String target_code,
                                double conversion_result) {
}
package com.aluracursos.challenge_currency_conversion.models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataConnection {

    private final List<ConversionRecord> conversionHistory = new ArrayList<>();

    public CurrencyConverter converter(String baseCurrency, String targetCurrency, double value){

        URI direction = URI.create("https://v6.exchangerate-api.com/v6/b06e14465aaa577d889ea75d/pair/"+baseCurrency+"/"+targetCurrency+"/"+value);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            CurrencyConverter result = new Gson().fromJson(response.body(), CurrencyConverter.class);

            // Registrar la conversión en el historial
            ConversionRecord conversionRecord = new ConversionRecord(
                    baseCurrency,
                    targetCurrency,
                    value,
                    result.conversion_result(),
                    LocalDateTime.now()
            );
            conversionHistory.add(conversionRecord);

            return result;
        } catch (Exception e) {
            throw new RuntimeException("No se logró hacer la conversión");
        }
    }

    public List<ConversionRecord> getConversionHistory() {
        return conversionHistory;
    }

    public void showConversionHistory() {
        List<ConversionRecord> conversionHistoryList = getConversionHistory();
        String bold = "\u001B[1m";
        String reset = "\u001B[0m";

        if(!conversionHistoryList.isEmpty()){
            System.out.println("------------------------------------------------");
            System.out.println(bold + "\t\t\t\t" + "***Historial***" + reset);
            System.out.println("------------------------------------------------");
            for (ConversionRecord record : conversionHistoryList) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy | HH:mm:ss");
                String formattedDateTime = record.dateTime().format(formatter);
                System.out.println(bold + "Fecha y hora: " + formattedDateTime);
                System.out.println("Conversión: " +
                        record.initialValue() + " " +
                        record.baseCurrency() + " A " +
                        record.convertedValue() + " " +
                        record.targetCurrency());
                System.out.println("------------------------------------------------" + reset);
            }
        }else {
            System.out.println("------------------------------------------------");
            System.out.println("No hay registros para mostrar\n");
        }
        System.out.println("¡Gracias por usar nuestro conversor de monedas!");
    }

}

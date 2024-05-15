package com.aluracursos.challenge_currency_conversion.view;

public class UI {


    public String getMenu(){
        String menu = """
                
                ************************************************
                *     ¡Bienvenido/a al Coversor de Moneda!     *    
                ************************************************
                                                             
                ***Opciones disponibles para convertir moneda***
                ------------------------------------------------
                |    1) Dólar =>> Peso argentino               |
                |    2) Peso argentino =>> Dólar               |
                |    3) Dólar =>> Real brasileño               | 
                |    4) Real brasileño =>> Dólar               |
                |    5) Dólar =>> Peso colombiano              |
                |    6) Peso colombiano =>> Dólar              |
                |    7) Más tipos de cambio                    |
                |    8) Salir                                  |
                ------------------------------------------------""";
        return menu;
    }

    public String getConversionHistoryView(){
        String conversionHistory = """
                 ¿Deseas obtener el historial de conversiones? 
                ------------------------------------------------
                  1. Sí
                  2. No 
                ------------------------------------------------""";

        return conversionHistory;
    }
}

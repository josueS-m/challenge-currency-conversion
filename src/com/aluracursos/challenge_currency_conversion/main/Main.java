package com.aluracursos.challenge_currency_conversion.main;

import com.aluracursos.challenge_currency_conversion.models.CurrencyConverter;
import com.aluracursos.challenge_currency_conversion.models.DataConnection;
import com.aluracursos.challenge_currency_conversion.view.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataConnection dataConnection = new DataConnection();
        Scanner inputOption = new Scanner(System.in);
        UI ui = new UI();
        int option = 0;
        double value;

        //---------------------------------------------------------------------
        //Código ANSI
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String magenta = "\u001B[36m";
        String reset = "\u001B[0m";
        //-----------------------------------------------------------------------

        while(option != 8) {

            System.out.println(green+ui.getMenu()+reset);
            System.out.print("Elija una opción válida: ");

            try{
                option = Integer.parseInt(inputOption.nextLine());

                switch (option){
                    case 1:
                        try {
                            System.out.println("------------------------------------------------");
                            System.out.println("USD a ARS");
                            System.out.print("Ingrese el valor que desea convertir: ");
                            value = Double.parseDouble(inputOption.nextLine());// Leer el valor como double
                            CurrencyConverter converterUSDAndARS = dataConnection.converter("USD", "ARS", value);

                            System.out.println("Conversión: "+ magenta + value +" "+ converterUSDAndARS.base_code()+" = "+
                                    converterUSDAndARS.conversion_result()+" "+
                                    converterUSDAndARS.target_code()+reset
                            );
                            System.out.println("------------------------------------------------");

                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un valor numérico válido.");
                            inputOption.nextLine(); // Limpiar el buffer
                            continue; // Saltar al siguiente ciclo del while
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("------------------------------------------------");
                            System.out.println("ARS a USD");
                            System.out.println("Ingrese el valor que desea convertir: ");
                            value = Double.parseDouble(inputOption.nextLine());// Leer el valor como double
                            CurrencyConverter converterARSAndUSD = dataConnection.converter("ARS", "USD", value);
                            System.out.println("Conversión: "+magenta + value+" "+converterARSAndUSD.base_code()+" = "+
                                    converterARSAndUSD.conversion_result()+" "+
                                    converterARSAndUSD.target_code() + reset
                            );
                            System.out.println("------------------------------------------------");

                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un valor numérico válido.");
                            inputOption.nextLine(); // Limpiar el buffer
                            continue; // Saltar al siguiente ciclo del while
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("------------------------------------------------");
                            System.out.println("USD a BRL");
                            System.out.println("Ingrese el valor que desea convertir: ");
                            value = Double.parseDouble(inputOption.nextLine());// Leer el valor como double
                            CurrencyConverter converterUSDAndBRL = dataConnection.converter("USD", "BRL", value);

                            System.out.println("Conversión: "+ magenta +value+" "+converterUSDAndBRL.base_code()+" = "+
                                    converterUSDAndBRL.conversion_result()+" "+
                                    converterUSDAndBRL.target_code() + reset
                            );
                            System.out.println("------------------------------------------------");
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un valor numérico válido.");
                            inputOption.nextLine(); // Limpiar el buffer
                            continue; // Saltar al siguiente ciclo del while
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("------------------------------------------------");
                            System.out.println("BRL a USD");
                            System.out.println("Ingrese el valor que desea convertir: ");
                            value = Double.parseDouble(inputOption.nextLine());// Leer el valor como double
                            CurrencyConverter converterBRLAndUSD = dataConnection.converter("BRL", "USD", value);

                            System.out.println("Conversión: "+ magenta +value+" "+converterBRLAndUSD.base_code()+" = "+
                                    converterBRLAndUSD.conversion_result()+" "+
                                    converterBRLAndUSD.target_code() + reset
                            );
                            System.out.println("------------------------------------------------");
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un valor numérico válido.");
                            inputOption.nextLine(); // Limpiar el buffer
                            continue; // Saltar al siguiente ciclo del while
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("------------------------------------------------");
                            System.out.println("USD a COP");
                            System.out.println("Ingrese el valor que desea convertir: ");
                            value = Double.parseDouble(inputOption.nextLine());// Leer el valor como double
                            CurrencyConverter converterUSDAndCOP = dataConnection.converter("USD", "COP", value);

                            System.out.println("Conversión: "+ magenta +value+" "+converterUSDAndCOP.base_code()+" = "+
                                    converterUSDAndCOP.conversion_result()+" "+
                                    converterUSDAndCOP.target_code() + reset
                            );
                            System.out.println("------------------------------------------------");
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un valor numérico válido.");
                            inputOption.nextLine(); // Limpiar el buffer
                            continue; // Saltar al siguiente ciclo del while
                        }
                        break;
                    case 6:
                        try {
                            System.out.println("------------------------------------------------");
                            System.out.println("COP a USD");
                            System.out.println("Ingrese el valor que desea convertir: ");
                            value = Double.parseDouble(inputOption.nextLine());// Leer el valor como double
                            CurrencyConverter converterCOPAndUSD = dataConnection.converter("COP", "USD", value);

                            System.out.println("Conversión: "+ magenta +value+" "+converterCOPAndUSD.base_code()+" = "+
                                    converterCOPAndUSD.conversion_result()+" "+
                                    converterCOPAndUSD.target_code() + reset
                            );
                            System.out.println("------------------------------------------------");
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Ingrese un valor numérico válido.");
                            inputOption.nextLine(); // Limpiar el buffer
                            continue; // Saltar al siguiente ciclo del while
                        }
                        break;

                    case 7:
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println( red + "Ejemplos del formato en que debes digitar las divisas =>> USD, BRL, COP" + reset);

                        System.out.println("\nIngrese la divisa base: ");
                        String baseCurrency = inputOption.nextLine().toUpperCase();
                        //Divisa a convertir
                        System.out.println("Ingrese la divisa a convertir: ");
                        String targetCurrency = inputOption.nextLine().toUpperCase();
                        //La cantidad que desea convertir
                        System.out.println("Ingrese el valor que desea convertir: ");
                        double conversionResult = Double.parseDouble(inputOption.nextLine());

                        CurrencyConverter converter = dataConnection.converter(baseCurrency, targetCurrency, conversionResult);

                        System.out.println("Conversión: "+ magenta +conversionResult + " " + converter.base_code() + " " +
                                converter.conversion_result() + " " + converter.target_code() + reset);
                        break;
                    case 8:
                        System.out.println("------------------------------------------------");
                        System.out.println(ui.getConversionHistoryView());
                        int subOption = 0; // Inicializar la subopción para que entre al bucle al menos una vez
                        do {
                            System.out.print("Por favor, elija una opción válida (1 o 2): ");
                            try {
                                subOption = Integer.parseInt(inputOption.nextLine());
                                if (subOption == 1) {
                                    dataConnection.showConversionHistory();
                                    option = 8; // Terminar el bucle, opción válida

                                } else if (subOption == 2) {
                                    System.out.println("¡Gracias por usar nuestro conversor de monedas!");
                                    option = 8;
                                } else {
                                    System.out.println(red+"Opción no válida"+reset);
                                    System.out.println("------------------------------------------------");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(red+"Error: Ingrese un valor válido."+reset);
                            }
                        } while (subOption != 1 && subOption != 2); // Repetir hasta que se elija una opción válida
                        break;
                    default:
                        System.out.println(red+"Opción no válida"+reset);
                }
            }catch (NumberFormatException e){
                System.out.println(red+"Error: Ingresar un valor válido"+reset);
            }
        }
    }
}

package main.java.com.sebastian.conversor.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class ConCurrency {

    private connectionAPI apiReq = new connectionAPI();
    private Gson gson = new Gson();

    private double result = 0;

    public double options(String option, double amount) {

        HashMap<String, Runnable> convertMapping = new HashMap<>();
        convertMapping.put("pesosadolar", () -> {
            double mxnToUsdRate = getConversionRate("MXN", "USD");
            result = mxnToUsdRate * amount;
        });
        convertMapping.put("pesosaeuro", () -> {
            double mxnToEurRate = getConversionRate("MXN", "EUR");
            result = mxnToEurRate * amount;
        });
        convertMapping.put("pesosalibras", () -> {
            double mxnToGbpRate = getConversionRate("MXN", "GBP");
            result = mxnToGbpRate * amount;
        });
        convertMapping.put("pesosayen", () -> {
            double mxnToJpyRate = getConversionRate("MXN", "JPY");
            result = mxnToJpyRate * amount;
        });
        convertMapping.put("pesosawoncoraneo", () -> {
            double mxnToKrwRate = getConversionRate("MXN", "KRW");
            result = mxnToKrwRate * amount;
        });
        convertMapping.put("dolarapesos", () -> {
            double usdToMxnRate = getConversionRate("USD", "MXN");
            result = usdToMxnRate * amount;
        });
        convertMapping.put("euroapesos", () -> {
            double eurToMxnRate = getConversionRate("EUR", "MXN");
            result = eurToMxnRate * amount;
        });
        convertMapping.put("librasapesos", () -> {
            double gbpToMxnRate = getConversionRate("GBP", "MXN");
            result = gbpToMxnRate * amount;
        });

        if (option != null && convertMapping.containsKey(option)) {
            Runnable runnable = convertMapping.get(option);
            runnable.run();
            return result;
        } else {
            // Manejar el caso en que el parámetro no tenga una asignación válida
            System.out.println("Conversion invalida");
        }

        return result;
    }

    private double getConversionRate(String currencyCode, String targetCurrency) {
        String json = apiReq.getJSON(currencyCode);
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        return conversionRates.get(targetCurrency).getAsDouble();
    }

}

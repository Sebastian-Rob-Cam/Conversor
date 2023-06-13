package main.java.com.sebastian.conversor.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class ConCurrency {

    private connectionAPI apiReq = new connectionAPI();
    private Gson gson = new Gson();

    public void options(String option, double amount) {
        HashMap<String, Runnable> convertMapping = new HashMap<>();
        convertMapping.put("pesosadolar", () -> {
            double mxnToUsdRate = getConversionRate("MXN", "USD");
            System.out.println(mxnToUsdRate * amount);
        });
        convertMapping.put("pesosaeuro", () -> {
            double mxnToEurRate = getConversionRate("MXN", "EUR");
            System.out.println(mxnToEurRate * amount);
        });
        convertMapping.put("pesosalibras", () -> {
            double mxnToGbpRate = getConversionRate("MXN", "GBP");
            System.out.println(mxnToGbpRate * amount);
        });
        convertMapping.put("pesosayen", () -> {
            double mxnToJpyRate = getConversionRate("MXN", "JPY");
            System.out.println(mxnToJpyRate * amount);
        });
        convertMapping.put("pesosawoncoraneo", () -> {
            double mxnToKrwRate = getConversionRate("MXN", "KRW");
            System.out.println(mxnToKrwRate * amount);
        });
        convertMapping.put("dolarapesos", () -> {
            double usdToMxnRate = getConversionRate("USD", "MXN");
            System.out.println(usdToMxnRate * amount);
        });
        convertMapping.put("euroapesos", () -> {
            double eurToMxnRate = getConversionRate("EUR", "MXN");
            System.out.println(eurToMxnRate * amount);
        });
        convertMapping.put("librasapesos", () -> {
            double gbpToMxnRate = getConversionRate("GBP", "MXN");
            System.out.println(gbpToMxnRate * amount);
        });

        if (option != null && convertMapping.containsKey(option)) {
            Runnable runnable = convertMapping.get(option);
            runnable.run();
        } else {
            // Manejar el caso en que el parámetro no tenga una asignación válida
            System.out.println("Conversion invalida");
        }

    }

    private double getConversionRate(String currencyCode, String targetCurrency) {
        String json = apiReq.getJSON(currencyCode);
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        return conversionRates.get(targetCurrency).getAsDouble();
    }

}

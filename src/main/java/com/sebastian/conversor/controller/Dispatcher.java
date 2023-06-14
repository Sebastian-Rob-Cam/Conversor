package main.java.com.sebastian.conversor.controller;

import main.java.com.sebastian.conversor.model.ConCurrency;
import main.java.com.sebastian.conversor.model.ConMeasures;
import main.java.com.sebastian.conversor.model.ConTemperature;

public class Dispatcher {

    public Dispatcher() {
    }

    public double todo(String type, String optionOfConversion, double amount) {

        double conversionResult = 0;

        if(type.equals("Currencys")) {
            ConCurrency currency = new ConCurrency();
            conversionResult = currency.options(optionOfConversion, amount);
        } else if (type.equals("Measures")) {
            ConMeasures measures = new ConMeasures();
            conversionResult = measures.options(optionOfConversion, amount);
        } else if (type.equals("Temperature")) {
            ConTemperature temperature = new ConTemperature();
            conversionResult = temperature.options(optionOfConversion, amount);
        } else {
            System.out.println("invalid value");
        }

        return conversionResult;
    }
}

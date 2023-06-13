package main.java.com.sebastian.conversor.controller;

import main.java.com.sebastian.conversor.model.ConCurrency;
import main.java.com.sebastian.conversor.model.ConMeasures;
import main.java.com.sebastian.conversor.model.ConTemperature;

public class Dispatcher {

    public Dispatcher() {
    }

    public void todo(String thing, String optionOfConversion, double amount) {

        if(thing.equals("currency")) {
            ConCurrency currency = new ConCurrency();
            currency.options(optionOfConversion, amount);
        } else if (thing.equals("measures")) {
            ConMeasures measures = new ConMeasures();
            measures.options(optionOfConversion, amount);
        } else if (thing.equals("temperature")) {
            ConTemperature temperature = new ConTemperature();
            System.out.println("convert temperature");
        } else {
            System.out.println("invalid value");
        }

    }
}

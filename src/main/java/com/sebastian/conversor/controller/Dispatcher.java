package main.java.com.sebastian.conversor.controller;

import main.java.com.sebastian.conversor.model.ConCurrency;
import main.java.com.sebastian.conversor.model.ConMeasures;
import main.java.com.sebastian.conversor.model.ConTemperature;

public class Dispatcher {

    public Dispatcher() {
    }

    public void todo(String thing, String optionOfConversion) {

        if(thing.equals("currency")) {
            ConCurrency currency = new ConCurrency();
            currency.options(optionOfConversion, 1);
        } else if (thing.equals("measures")) {
            ConMeasures measures = new ConMeasures();
            System.out.println("convert measures");
        } else if (thing.equals("temperature")) {
            ConTemperature temperature = new ConTemperature();
            System.out.println("convert temperature");
        } else {
            System.out.println("invalid value");
        }

    }
}

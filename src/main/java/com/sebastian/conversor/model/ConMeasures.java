package main.java.com.sebastian.conversor.model;

import java.util.HashMap;

public class ConMeasures {

    private double result = 0;

    public double options(String option, double num) {

        HashMap<String, Runnable> convertMapping = new HashMap<>();
        convertMapping.put("cmainch", () -> {
            double oneCmToInch = 0.39370079;
            result = oneCmToInch * num;
        });
        convertMapping.put("cmafeet", () -> {
            double oneCmToFeet = 0.0328084;
            result = oneCmToFeet * num;
        });
        convertMapping.put("kmamilla", () -> {
            double oneKmToMile = 0.621371;
            result = oneKmToMile * num;
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

}

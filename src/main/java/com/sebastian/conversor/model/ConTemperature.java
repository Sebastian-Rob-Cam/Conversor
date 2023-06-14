package main.java.com.sebastian.conversor.model;

import java.util.HashMap;

public class ConTemperature {

    private double result = 0;

    public double options(String option, double grades) {

        HashMap<String, Runnable> convertMapping = new HashMap<>();
        convertMapping.put("celsiusafahrenheit", () -> {
            double celToFahFormula = ((grades * 1.8) + 32);
            result = celToFahFormula;
        });
        convertMapping.put("fahrenheitacelsius", () -> {
            double fahToCelFormula = ((grades - 32) / 1.8);
            result = fahToCelFormula;
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

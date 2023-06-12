package main.java.com.sebastian.conversor.model;

import java.util.HashMap;

public class ConMeasures {

    public void options(String option) {

        HashMap<String, Runnable> convertMapping = new HashMap<>();
        convertMapping.put("cmainch", () -> {});
        convertMapping.put("cmafeet", () -> {});
        convertMapping.put("kmamilla", () -> {});

        if (option != null && convertMapping.containsKey(option)) {
            Runnable runnable = convertMapping.get(option);
            runnable.run();
        } else {
            // Manejar el caso en que el parámetro no tenga una asignación válida
            System.out.println("Conversion invalida");
        }

    }

}

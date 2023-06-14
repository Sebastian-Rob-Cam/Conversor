package main.java.com.sebastian.conversor.view.windows;

import main.java.com.sebastian.conversor.controller.Dispatcher;
import main.java.com.sebastian.conversor.view.windows.result.ConversionResultWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureOptionsWindow extends JFrame {

    private JComboBox<String> conversionComboBox;
    private JTextField amountTextField;
    private JButton convertButton;

    public TemperatureOptionsWindow(String type) {
        setTitle("Measures Options");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear un JPanel para agrupar los componentes y agregar un margen
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Margen de 10 píxeles en cada lado
        setContentPane(mainPanel);

        // Establecer el tamaño de la ventana principal
        int width = 400;
        int height = 200;
        setPreferredSize(new Dimension(width, height));

        // Label and ComboBox for conversion options
        JLabel conversionLabel = new JLabel("Conversion Options:");
        conversionComboBox = new JComboBox<>(new String[]{"celsiusafahrenheit", "fahrenheitacelsius"});
        mainPanel.add(conversionLabel);
        mainPanel.add(conversionComboBox);

        // Label and Text Field for amount
        JLabel measureLabel = new JLabel("amount:");
        amountTextField = new JTextField();
        mainPanel.add(measureLabel);
        mainPanel.add(amountTextField);

        // Convert Button
        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) conversionComboBox.getSelectedItem();
                double amount = Double.valueOf(amountTextField.getText());
                Dispatcher dispatcher = new Dispatcher();
                double result = dispatcher.todo(type, selectedOption, amount);
                ConversionResultWindow resultWindow = new ConversionResultWindow(result);
            }
        });
        mainPanel.add(convertButton);

        pack(); // Ajustar el tamaño de la ventana según su contenido
    }
}



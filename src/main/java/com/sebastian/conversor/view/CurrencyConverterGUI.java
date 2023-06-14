package main.java.com.sebastian.conversor.view;

import main.java.com.sebastian.conversor.view.windows.CurrencyOptionsWindow;
import main.java.com.sebastian.conversor.view.windows.MeasuresOptionsWindow;
import main.java.com.sebastian.conversor.view.windows.TemperatureOptionsWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI extends JFrame {

    private JComboBox<String> thingComboBox;
    private JComboBox<String> optionComboBox;
    private JTextField amountTextField;
    private JButton convertButton;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un JPanel para agrupar los componentes y agregar un margen
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Margen de 10 píxeles en cada lado
        setContentPane(mainPanel);

        // Crear los componentes
        JLabel thingLabel = new JLabel("Hola, que quieres convertir:");
        thingComboBox = new JComboBox<>(new String[]{"Currencys", "Measures", "Temperature"});

        // Agregar los componentes al panel principal
        mainPanel.add(thingLabel);
        mainPanel.add(thingComboBox);

        // Establecer el tamaño de la ventana principal
        int width = 400;
        int height = 200;
        setPreferredSize(new Dimension(width, height));

        // Agregar un ActionListener al combobox
        thingComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) thingComboBox.getSelectedItem();
                openOptionWindow(selectedItem);
            }
        });

        pack(); // Ajustar el tamaño de la ventana según su contenido
    }

    private void openOptionWindow(String selectedOption) {
        if (selectedOption.equals("Currencys")) {
            CurrencyOptionsWindow currencyOptionsWindow = new CurrencyOptionsWindow(selectedOption);
            currencyOptionsWindow.setVisible(true);
        } else if (selectedOption.equals("Measures")) {
            MeasuresOptionsWindow measuresOptionsWindow = new MeasuresOptionsWindow(selectedOption);
            measuresOptionsWindow.setVisible(true);
        } else if (selectedOption.equals("Temperature")) {
            TemperatureOptionsWindow temperatureOptionsWindow = new TemperatureOptionsWindow(selectedOption);
            temperatureOptionsWindow.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CurrencyConverterGUI gui = new CurrencyConverterGUI();
                gui.setVisible(true);
            }
        });
    }
}
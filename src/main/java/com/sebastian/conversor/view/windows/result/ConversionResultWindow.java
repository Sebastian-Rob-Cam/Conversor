package main.java.com.sebastian.conversor.view.windows.result;

import javax.swing.*;
import java.awt.*;

public class ConversionResultWindow extends JFrame {

    public ConversionResultWindow(double conversionResult) {
        setTitle("Conversion Result");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);

        // Label to display the conversion result
        JLabel resultLabel = new JLabel("Conversion Result: " + conversionResult);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(resultLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}


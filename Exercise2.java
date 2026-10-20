import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JTextField lengthField;
    private JTextField widthField;
    private JLabel resultLabel;

    public Main() {
        setTitle("Rectangle Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter Length:"));
        lengthField = new JTextField(10);
        add(lengthField);

        add(new JLabel("Enter Width:"));
        widthField = new JTextField(10);
        add(widthField);

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        resultLabel = new JLabel("Area and perimeter will show here.");
        add(resultLabel);

        calculateButton.addActionListener(e -> {
            try {
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());

                double area = length * width;
                double perimeter = 2 * (length + width);

                resultLabel.setText(
                    "Area: " + area + " | Perimeter: " + perimeter
                );

            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}

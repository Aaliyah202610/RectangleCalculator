import javax.swing.*;
import java.awt.*;

public class NewClass1 extends JFrame {

    private JTextField weightField;
    private JTextField heightField;
    private JLabel bmiLabel;
    private JLabel categoryLabel;

    public NewClass1() {
        setTitle("BMI Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Weight (kg):"));
        weightField = new JTextField(10);
        add(weightField);

        add(new JLabel("Height (m):"));
        heightField = new JTextField(10);
        add(heightField);

        JButton calculateButton = new JButton("Calculate BMI");
        add(calculateButton);

        bmiLabel = new JLabel("BMI: ");
        categoryLabel = new JLabel("Weight Category: ");

        add(bmiLabel);
        add(categoryLabel);

        calculateButton.addActionListener(e -> {
            try {
                double weight =
                    Double.parseDouble(weightField.getText());
                double height =
                    Double.parseDouble(heightField.getText());

                if (weight <= 0 || height <= 0) {
                    bmiLabel.setText("Enter positive numbers.");
                    categoryLabel.setText("");
                    return;
                }

                double bmi = weight / (height * height);

                bmiLabel.setText(
                    String.format("BMI: %.2f", bmi)
                );

                if (bmi < 18.5) {
                    categoryLabel.setText("Category: Underweight");
                } else if (bmi < 25) {
                    categoryLabel.setText("Category: Healthy range");
                } else if (bmi < 30) {
                    categoryLabel.setText("Category: Overweight");
                } else {
                    categoryLabel.setText("Category: Obesity range");
                }

            } catch (NumberFormatException ex) {
                bmiLabel.setText("Enter valid numbers.");
                categoryLabel.setText("");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new NewClass1();
    }
}

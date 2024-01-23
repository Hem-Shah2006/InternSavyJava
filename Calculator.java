import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator extends JFrame {
    private JTextField display;
    public Calculator() {
        setTitle("Basic Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null); 
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }
        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();
            if (buttonText.equals("=")) {
                calculateResult();
            } else {
                display.setText(display.getText() + buttonText);
            }
        }
    }
    private void calculateResult() {
        try {
            String expression = display.getText();
            double result = evaluateExpression(expression);
            display.setText(Double.toString(result));
        } catch (Exception ex) {
            display.setText("Error");
        }
    }
    private double evaluateExpression(String expression) {
        // Use a library or implement your own expression evaluator
        // For simplicity, this example assumes a basic calculator with only basic operations
        return (double) new ScriptEngineManager().getEngineByName("JavaScript")
                .eval(expression);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculatorApp = new Calculator();
            calculatorApp.setVisible(true);
        });
    }
}
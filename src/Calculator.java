import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] buttons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subtractionButton, multiplyButton, divideButton;
    JButton decimalButton, equationButton, deleteButton, clearButton, negativeButton;
    JPanel jPanel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equationButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negativeButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equationButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;

        for(int i = 0; i < 9; ++i) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i < 10; ++i) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
            buttons[i].setFont(myFont);
            buttons[i].setFocusable(false);
        }

        negativeButton.setBounds(50, 430, 100, 50);
        deleteButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);

        jPanel = new JPanel();
        jPanel.setBounds(50, 100, 300, 300);
        jPanel.setLayout(new GridLayout(4, 4, 10, 10));
//        jPanel.setBackground(Color.GRAY);

        jPanel.add(buttons[1]);
        jPanel.add(buttons[2]);
        jPanel.add(buttons[3]);
        jPanel.add(addButton);

        jPanel.add(buttons[4]);
        jPanel.add(buttons[5]);
        jPanel.add(buttons[6]);
        jPanel.add(subtractionButton);

        jPanel.add(buttons[7]);
        jPanel.add(buttons[8]);
        jPanel.add(buttons[9]);
        jPanel.add(multiplyButton);
        jPanel.add(decimalButton);
        jPanel.add(buttons[0]);
        jPanel.add(equationButton);
        jPanel.add(divideButton);

        frame.add(jPanel);
        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; ++i) {
            if(e.getSource() == buttons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subtractionButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource() == equationButton) {
            num2 = Double.parseDouble(textField.getText());

            switch(operator) {
                case '+' :
                    result = num1 + num2;
                    break;

                case '-' :
                    result = num1 - num2;
                    break;

                case '*' :
                    result = num1 * num2;
                    break;

                case '/' :
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == clearButton) {
            textField.setText("");
        }

        if(e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

        if(e.getSource() == deleteButton) {
            String st = textField.getText();
            textField.setText("");
            for(int i = 0; i < st.length() - 1; ++i) {
                //since text is deleted, you add text one char by char until length() - 1
                //because we want to have String without last char
                textField.setText(textField.getText() + st.charAt(i));
            }
        }
    }
}

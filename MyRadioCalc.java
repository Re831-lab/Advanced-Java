/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myradiocalc;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyRadioCalc extends JFrame {
    private JPanel northPanel, southPanel;
    private JLabel label, resultLabel;
    private JTextField textField;
    private JRadioButton r1, r2;
    private ButtonGroup langGroup;
    private JButton calcButton, generalCalcButton;
    private JComboBox<String> comb;
    private JCheckBox checkBox;
    
    public MyRadioCalc() {
       
        super("حاسبة بسيطة");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        northPanel = new JPanel();
        southPanel = new JPanel();
        
        label = new JLabel("Enter Data");
        textField = new JTextField(15);
        
        r1 = new JRadioButton("Ar");
        r2 = new JRadioButton("En", true); 
        langGroup = new ButtonGroup();
        langGroup.add(r1);
        langGroup.add(r2);
        
        String[] operations = {"sqr", "sqrt", "!"};
        comb = new JComboBox<>(operations);
        
        calcButton = new JButton("GetAns");
        
        generalCalcButton = new JButton("Calculate");
        
        checkBox = new JCheckBox("تفعيل", true);
        
        northPanel.add(label);
        northPanel.add(textField);
        northPanel.add(r1);
        northPanel.add(r2);
        northPanel.add(comb);
        northPanel.add(calcButton);
        northPanel.add(generalCalcButton);
        northPanel.add(checkBox);
        
        resultLabel = new JLabel("الجواب سيظهر هنا");
        southPanel.add(resultLabel);
        
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        
        r1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("أدخل البيانات");
                calcButton.setText("احسب");
                generalCalcButton.setText("حساب عام");
            }
        });
        
        r2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Enter Data");
                calcButton.setText("GetAns");
                generalCalcButton.setText("Calculate");
            }
        });
        
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isEnabled = checkBox.isSelected();
                textField.setEnabled(isEnabled);
                r1.setEnabled(isEnabled);
                r2.setEnabled(isEnabled);
                comb.setEnabled(isEnabled);
                calcButton.setEnabled(isEnabled);
                generalCalcButton.setEnabled(isEnabled);
            }
        });
        
        comb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
        
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
        
        generalCalcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGeneralResult();
            }
        });
        
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    comb.addItem(text);
                }
            }
        });
    }
    
    private void calculateResult() {
        try {
            int num = Integer.parseInt(textField.getText());
            String operation = (String) comb.getSelectedItem();
            String result = "";
            
            if (operation.equals("sqr")) {
                result = Integer.toBinaryString(num * num);
            } else if (operation.equals("sqrt")) {
                result = Integer.toBinaryString((int) Math.sqrt(num));
            } else if (operation.equals("!")) {
                result = Integer.toBinaryString(factorial(num));
            } else {
                result = Integer.toBinaryString(num); 
            }
            
            if (r2.isSelected()) {
                resultLabel.setText("The Ans is: " + result);
            } else {
                resultLabel.setText("الجواب هو: " + result);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("الرجاء إدخال رقم صحيح");
        }
    }
    
    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    private void calculateGeneralResult() {
        try {
            int num = Integer.parseInt(textField.getText());
            String operation = (String) comb.getSelectedItem();
            int result = 0;
            
            if (operation.equals("sqr")) {
                result = num * num;
            } else if (operation.equals("sqrt")) {
                result = (int) Math.sqrt(num);
            } else if (operation.equals("!")) {
                result = factorial(num);
            } else {
                result = num;             }
            
            if (r2.isSelected()) {
                resultLabel.setText("The General Result is: " + result);
            } else {
                resultLabel.setText("النتيجة العامة هي: " + result);
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("الرجاء إدخال رقم صحيح");
        }
    }
    
    private void removeItem() {
        String text = textField.getText();
        for (int i = 0; i < comb.getItemCount(); i++) {
            if (comb.getItemAt(i).equals(text)) {
                comb.removeItemAt(i);
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyRadioCalc().setVisible(true);
            }
        });
    }
}
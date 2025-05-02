/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainnn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame implements ActionListener {
    // عناصر الواجهة
    private JTextField nameField, emailField, contactField;
    private JRadioButton maleRadio, femaleRadio;
    private JTextArea addressArea;
    private JComboBox<String> countryCombo, stateCombo;
    private JCheckBox pythonCheck, biCheck;
    private JButton registerButton;

    public RegistrationForm() {
        // إعداد النافذة الأساسية
        setTitle("ITVoyagers Registration Form");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2, 5, 5));

        // إضافة عناصر الواجهة
        add(new JLabel("Name of visitor:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Favourite programming language:"));
        JTextField langField = new JTextField();
        add(langField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        add(genderPanel);

        add(new JLabel("Address:"));
        addressArea = new JTextArea(3, 20);
        add(new JScrollPane(addressArea));

        add(new JLabel("Email id:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Contact no:"));
        contactField = new JTextField();
        add(contactField);

        add(new JLabel("Country:"));
        String[] countries = {"Select", "USA", "India", "UK", "Other"};
        countryCombo = new JComboBox<>(countries);
        add(countryCombo);

        add(new JLabel("State:"));
        String[] states = {"Select", "California", "Maharashtra", "Texas", "Other"};
        stateCombo = new JComboBox<>(states);
        add(stateCombo);

        add(new JLabel("Select topics:"));
        JPanel topicsPanel = new JPanel();
        pythonCheck = new JCheckBox("Python");
        biCheck = new JCheckBox("Business Intelligence");
        topicsPanel.add(pythonCheck);
        topicsPanel.add(biCheck);
        add(topicsPanel);

        registerButton = new JButton("REGISTER HERE");
        registerButton.addActionListener(this);
        add(registerButton);

        setVisible(true);
    }

    // حدث زر التسجيل
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            // جمع البيانات
            String data = "Registration Details:\n" +
                "Name: " + nameField.getText() + "\n" +
                "Gender: " + (maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : "") + "\n" +
                "Address: " + addressArea.getText() + "\n" +
                "Email: " + emailField.getText() + "\n" +
                "Contact: " + contactField.getText() + "\n" +
                "Country: " + countryCombo.getSelectedItem() + "\n" +
                "State: " + stateCombo.getSelectedItem() + "\n" +
                "Topics: " + (pythonCheck.isSelected() ? "Python " : "") + 
                (biCheck.isSelected() ? "Business Intelligence" : "");
            
            JOptionPane.showMessageDialog(this, data);
        }
    }


}
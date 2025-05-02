/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainn;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyRadioCalc extends JFrame {
    private JTextField txtData;
    private JRadioButton r1, r2;
    private JButton btnAns;
    private JPanel paneNorth, paneSouth;
    private ButtonGroup group;

    public MyRadioCalc() {
        setTitle("Radio Button Example");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Components
        txtData = new JTextField(20);

        r1 = new JRadioButton("Ar");
        r2 = new JRadioButton("En");

        btnAns = new JButton("GetAns");

        // Panels
        paneNorth = new JPanel();
        paneSouth = new JPanel();

        // Add components to paneNorth
        paneNorth.setLayout(new GridLayout(2, 1));
        JPanel upper = new JPanel();
        JPanel lower = new JPanel();

        upper.add(new JLabel("Enter Data:"));
        upper.add(txtData);

        lower.add(r1);
        lower.add(r2);

        paneNorth.add(upper);
        paneNorth.add(lower);

        // Add button to paneSouth
        paneSouth.add(btnAns);

        // Group radio buttons
        group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        // Add panels to frame
        add(paneNorth, BorderLayout.NORTH);
        add(paneSouth, BorderLayout.SOUTH);

        // ActionListener for the button
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = txtData.getText();
                if (r1.isSelected()) {
                    JOptionPane.showMessageDialog(null, "الجواب هو: " + data);
                } else if (r2.isSelected()) {
                    JOptionPane.showMessageDialog(null, "The Ans is: " + data);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a language.");
                }
            }
        });
    
    }
}
 

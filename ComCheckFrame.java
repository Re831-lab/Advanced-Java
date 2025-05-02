/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Dell
 */



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComCheckFrame extends JFrame {
    JComboBox<String> comb;
    JLabel lblAns;
    JTextField txt;
    JCheckBox chb;
    JButton btn, btn2;

    public ComCheckFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 200);
        setLocation(400, 300);

     
        String[] arr = {"sqr", "sqrt", "!"};
        comb = new JComboBox<>(arr);
        lblAns = new JLabel(" ");
        txt = new JTextField(10);
        chb = new JCheckBox(" is active ");
        btn = new JButton("Calc");
        btn2 = new JButton("Remove");

        
        btn.addActionListener(e -> calculate());

       
        chb.addActionListener(e -> {
            boolean enabled = !chb.isSelected();
            comb.setEnabled(enabled);
            btn.setEnabled(enabled);
            txt.setEnabled(enabled);
            btn2.setEnabled(enabled);
        });

       
        comb.addActionListener(e -> calculate());

       
        btn.addActionListener(e -> comb.addItem(txt.getText()));

        btn2.addActionListener(e -> comb.removeItem(txt.getText()));

       
        JPanel paneNorth = new JPanel(new GridLayout(2, 1));
        paneNorth.add(comb);
        paneNorth.add(txt);

        JPanel paneCenter = new JPanel();
        paneCenter.add(chb);
        paneCenter.add(btn);
        paneCenter.add(btn2);

        JPanel paneSouth = new JPanel();
        paneSouth.add(lblAns);

        add(paneNorth, BorderLayout.NORTH);
        add(paneCenter, BorderLayout.CENTER);
        add(paneSouth, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void calculate() {
        try {
            int x = Integer.parseInt(txt.getText());
            String selected = comb.getSelectedItem().toString();

            if (selected.equals("sqr")) {
                lblAns.setText("the Ans is : " + (x * x));
            } else if (selected.equals("sqrt")) {
                lblAns.setText("the Ans is : " + Math.sqrt(x));
            } else if (selected.equals("!")) {
                int fact = 1;
                for (int i = 1; i <= x; i++) {
                    fact *= i;
                }
                lblAns.setText("the Ans is : " + fact);
            }
        } catch (NumberFormatException ex) {
            lblAns.setText("Invalid input!");
        }
    }

    
}
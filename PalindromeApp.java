/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeApp extends JFrame {
    private JTextField txtData;
    private JLabel lblLen, lblCap, lblSmall, lblPal;
    private JButton btnCalc, btnClear;
    private JPanel paneNorth, paneCenter, paneSouth;

    public PalindromeApp() {
        setTitle("Palindrome Checker");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtData = new JTextField(20);

        lblLen = new JLabel("Length: ");
        lblCap = new JLabel("Capital Letters: ");
        lblSmall = new JLabel("Small Letters: ");
        lblPal = new JLabel("Palindrome? ");

        btnCalc = new JButton("Calc");
        btnClear = new JButton("Clear");

        paneNorth = new JPanel();
        paneCenter = new JPanel();
        paneSouth = new JPanel();

        paneNorth.setLayout(new GridLayout(1, 0));
        paneNorth.add(txtData);

        paneCenter.setLayout(new GridLayout(2, 2));
        paneCenter.add(lblLen);
        paneCenter.add(lblCap);
        paneCenter.add(lblSmall);
        paneCenter.add(lblPal);

        paneSouth.setLayout(new GridLayout(1, 2));
        paneSouth.add(btnCalc);
        paneSouth.add(btnClear);

        add(paneNorth, BorderLayout.NORTH);
        add(paneCenter, BorderLayout.CENTER);
        add(paneSouth, BorderLayout.SOUTH);

        // Action listeners
        btnCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = txtData.getText();
                lblLen.setText("Length: " + str.length());
                lblCap.setText("Capital Letters: " + numOfCap(str));
                lblSmall.setText("Small Letters: " + numOfSmall(str));
                if (isPal(str))
                    lblPal.setText("Palindrome");
                else
                    lblPal.setText("Not Palindrome");
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtData.setText("");
                lblLen.setText("Length: ");
                lblCap.setText("Capital Letters: ");
                lblSmall.setText("Small Letters: ");
                lblPal.setText("Palindrome? ");
            }
        });

       
        txtData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalc.doClick();
            }
        });

        
        txtData.setBackground(Color.CYAN);
        paneCenter.setBackground(Color.RED);
        getContentPane().setBackground(Color.PINK);

     
        paneNorth.setBorder(BorderFactory.createTitledBorder("Input"));
        paneCenter.setBorder(BorderFactory.createTitledBorder("Result"));
        paneSouth.setBorder(BorderFactory.createTitledBorder("Calculation"));

        lblPal.setOpaque(true);
        lblPal.setBackground(Color.BLACK);
        lblPal.setForeground(Color.WHITE);

       
    }

    
    public boolean isPal(String str) {
        str = str.toLowerCase(); // ignore case
        int j = str.length() - 1;
        for (int i = 0; i <= str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

   
    public int numOfCap(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)))
                count++;
        }
        return count;
    }

    
    public int numOfSmall(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i)))
                count++;
        }
        return count;
    } 
}
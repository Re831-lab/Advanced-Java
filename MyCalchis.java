/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tasl;

/**
 *
 * @author Dell
 */

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.Date;



public class MyCalchis extends JFrame {
    JLabel lblAns, lbUval1, lbUval2;
    JButton btn;
    JTextField txtVal1, txtVal2;
    JTextArea textArea;
    JScrollPane sPane;

    public MyCalchis(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocation(400, 300);
        this.setLayout(new GridLayout(3, 1));

        lblAns = new JLabel("");
        lbUval1 = new JLabel("Value 1");
        lbUval2 = new JLabel("Value 2");
        btn = new JButton("Calc");
        txtVal1 = new JTextField();
        txtVal2 = new JTextField();
        textArea = new JTextArea();
        sPane = new JScrollPane(textArea);

        // إعداد لوحة الإدخال
        JPanel paneData = new JPanel();
        paneData.setLayout(new GridLayout(2, 2));
        paneData.setBorder(BorderFactory.createTitledBorder("Input Data"));
        paneData.add(lbUval1);
        paneData.add(txtVal1);
        paneData.add(lbUval2);
        paneData.add(txtVal2);

        // إعداد لوحة الحساب
        JPanel paneCalc = new JPanel();
        paneCalc.setLayout(new GridLayout(1, 2));
        paneCalc.setBorder(BorderFactory.createTitledBorder("Calculation Data"));
        paneCalc.add(btn);
        paneCalc.add(lblAns);

        // إضافة المكونات إلى الإطار
        this.add(paneData);
        this.add(paneCalc);
        this.add(sPane);

        // MouseListener للزر
        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double x = Double.parseDouble(txtVal1.getText());
                double y = Double.parseDouble(txtVal2.getText());
                lblAns.setText("Ans : " + (x + y));
                printToTextArea("mouse click --> " + lblAns.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblAns.setOpaque(true);
                lblAns.setBackground(Color.PINK);
                printToTextArea("mouse entered --> lbl bg change to pink");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblAns.setBackground(Color.GRAY);
                printToTextArea("mouse exited --> lbl bg change to gray");
            }
        });

        // DocumentListener للحقول النصية
        txtVal1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printToTextArea("txt1 --> insert event: " + txtVal1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printToTextArea("txt1 --> remove event: " + txtVal1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        txtVal2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printToTextArea("txt2 --> insert event: " + txtVal2.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printToTextArea("txt2 --> remove event: " + txtVal2.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        this.setVisible(true);
    }

    // طريقة لإضافة النص إلى textArea
    public void printToTextArea(String str) {
        textArea.append("***********\n");
        textArea.append(new Date() + " --> " + str + "\n");
    }


  
}

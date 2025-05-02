/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import javax.swing.SwingUtilities;

/**
 *
 * @author Dell
 */
public class Mavenproject1 {

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        ComCheckFrame frame = new ComCheckFrame("Calculator");
        frame.setVisible(true);
    });
}}
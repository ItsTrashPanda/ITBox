package main.java.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{

    private JTextArea inputField;


    private JPanel mainPanel;
    private JTextArea outputField;
    private JComboBox classSelection;
    private JButton runCalc;
    private boolean pressed = false;


    public GUI(){


        runCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressed = true;
            }
        });
    }
    public String getInput() {return inputField.getText();}
    public Integer getClassType() {return classSelection.getSelectedIndex();}

    public static void main(String[] args){
        GUI g = new GUI();
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setLocationRelativeTo(null);
        g.setContentPane(g.mainPanel);
        g.pack();
        g.setTitle("ITBox tool kit");
        g.setSize(500,400);
        g.setLocationRelativeTo(null);
        g.setVisible(true);
    }

    public void initializeGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(this.mainPanel);
        this.pack();
        this.setTitle("ITBox tool kit");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setOutput(String output) {
        /*if (!outputField.getText().equals("")) {
            outputField.selectAll();
            outputField.replaceSelection("");
        }

         */
        outputField.setText(output);
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
}
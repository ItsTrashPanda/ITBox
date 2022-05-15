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


    public GUI(){


        runCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public String getMenu() {return inputField.getText();}
    public Integer getClassType() {return classSelection.getSelectedIndex();}

    public static void main(String[] args){
        GUI g = new GUI();
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setLocationRelativeTo(null);
        g.setContentPane(g.mainPanel);
        g.pack();
        g.setTitle("ITBox tool kit");
        g.setSize(400,300);
        g.setLocationRelativeTo(null);
        g.setVisible(true);
    }
}
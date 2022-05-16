package main.java.application;

import main.java.application.GUI;
import main.java.tools.SubnetCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SubnetCalculator Calc = new SubnetCalculator();
        GUI gui = new GUI();

        gui.initializeGUI();
        while(true) {
            Calc.setSubnetClass(gui.getClassType());
            if (gui.isPressed()) {
                ArrayList<Integer> sHosts = new ArrayList<>();
                Calc.setRequiredHosts(sHosts);
                String[] temp = gui.getInput().split("\n");
                for (String i:temp) {
                    sHosts.add(Integer.parseInt(i.replaceAll("\n", "")));
                }
                Calc.calculate();
                String output = "";
                int j = 0;
                for(String[] i: Calc.getIpRanges()) {
                    j++;
                    output = output + "Subnet " + j + "\n" + "Network Address: " + i[0] + "\n" + "First Host Address: " + i[1]
                            + "\n" + "Last Host Address: " + i[2] + "\n" + "Broadcast Address: " + i[3] + "\n" + "Subnet Mask: " + i[4] + "\n\n";
                }
                gui.setOutput(output);
                gui.setPressed(false);
            }
        }
    }
}

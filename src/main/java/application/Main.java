package application;

import tools.SubnetCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String sClass = "";
        String input = "";
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        SubnetCalculator calc;

        System.out.println("Please enter a Subnet Class");
        sClass = scanner.nextLine();
        System.out.println("Please enter a host size or an x");
        while (!input.equals("x")) {
            input = scanner.nextLine();
            if (!input.equals("x")) {
                list.add(input);
            }
        }
        for(String s:list) {
            intList.add(Integer.parseInt(s));
        }
        calc = new SubnetCalculator(sClass, intList);
        calc.calculate();
        int j = 0;
        for(String[] i: calc.getIpRanges()) {
            j++;
            System.out.println("Subnet " + j);
            System.out.println("Network Address: " + i[0]);
            System.out.println("First Host Address: " + i[1]);
            System.out.println("Last Host Address: " + i[2]);
            System.out.println("Broadcast Address: " + i[3]);
            System.out.println("Subnet Mask: " + i[4]);
        }
    }
}

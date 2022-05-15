package main.java.application;
import javax.swing.*;

public class GUI extends JFrame{
    public int numHosts;
    public String ClassType;

    private JButton StartCalc;
    private JTextField NetworkField;
    private JTextField LastUseField;
    private JTextField FirstUseField;
    private JTextField BroadcastField;
    private JTextField ClassTypeField;

    private JPanel mainPanel;
    private JTextArea HostBoxField;


    public GUI(){
        //numHosts = initHosts;
        //ClassType = initClassT;
        /*
        StartCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test");
            }
        });

         */
    }
    public String getNetwork() {
        return NetworkField.getText();
    }
    public String getLast() {
        return LastUseField.getText();
    }
    public String getFirst() {
        return FirstUseField.getText();
    }
    public String getBroadcast() {
        return BroadcastField.getText();
    }
    public String getClassType() {
        return ClassTypeField.getText();
    }

    public static void main(String[] args){
        GUI g = new GUI();
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(300,400);
        g.setLocationRelativeTo(null);
        g.setContentPane(g.mainPanel);
        g.pack();
        g.setVisible(true);
    }
}
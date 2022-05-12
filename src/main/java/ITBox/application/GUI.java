package ITBox.application;
import ITBox.tools.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    GUI(int initHosts, String initClassT){
        //numHosts = initHosts;
        //ClassType = initClassT;
        StartCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(StartCalc, ClassTypeField.getText()+" Numbers");
            }
        });

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
        JFrame g = new JFrame("Subnet calc");
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(1920,1080);
        g.setLocationRelativeTo(null);
        //g.setContentPane(new mainPanel);
        JButton button1 = new JButton("Press");
        g.setVisible(true);
    }



}

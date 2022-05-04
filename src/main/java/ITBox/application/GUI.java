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
        numHosts = initHosts;
        ClassType = initClassT;
        StartCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(StartCalc, ClassTypeField.getText()+" Numbers");
            }
        });
    }

    public static void main(String[] args){
        GUI g=new GUI(3, "test");
        g.setVisible(true);
        g.setSize(300,400);
        g.setContentPane(g.mainPanel);
        g.setTitle("Menu");


    }



}

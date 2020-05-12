package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class MainFrame {

    static JPanel designPanel;
    static JButton b;
    static JLabel label;
    static JButton buttonAdd;
    static JTextField textField;

    public void remove() {
        designPanel.removeAll();
        designPanel.revalidate();
        designPanel.repaint();
    }

    public void addElement() {
        buttonAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String driverName = textField.getText();
                Class clazz;
                try {            
                    clazz = Class.forName(driverName);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

    }

    public MainFrame() {
        JFrame frame = new JFrame("Dynamic Swing Designer");
        frame.setSize(710, 500);
        frame.setLocation(200, 200);
        textField = new JTextField();
        textField.setBounds(80, 25, 200, 30);
        frame.add(textField);
        frame.add(textField, BorderLayout.NORTH);

        this.buttonAdd = new JButton("Add swing element");
        buttonAdd.setBounds(300, 20, 150, 40);
        frame.add(buttonAdd, BorderLayout.NORTH);

        JButton buttonRemove = new JButton("Delete element");
        buttonRemove.setBounds(490, 20, 130, 40);
        frame.add(buttonRemove, BorderLayout.NORTH);

        designPanel = new JPanel();
        designPanel.setBounds(70, 70, 550, 350);
        designPanel.setBackground(Color.white);
        designPanel.setLayout(null);
   

        addElement();
        buttonRemove.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0
            ) {
                remove();
            }
        }
        );

        frame.setLayout(null);
        frame.add(designPanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI extends JFrame {


    private JButton b = new JButton("import");
    private JFileChooser bb = new JFileChooser();
    private JButton b2 = new JButton("export");


    public GUI() {

        super("form");
        this.setBounds(300, 300, 600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Excel exc = new Excel();
        Calculate calc = new Calculate();
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 2));
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int returnvalue = bb.showOpenDialog(GUI.this);
                    if (returnvalue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = bb.getSelectedFile();
                        exc.read(selectedFile.getAbsolutePath());
                        JOptionPane.showMessageDialog(null, "Done", "Import", JOptionPane.PLAIN_MESSAGE);
                    }


                } catch (HeadlessException headlessException) {
                    JOptionPane.showMessageDialog(null, "Not found", "Error", JOptionPane.PLAIN_MESSAGE);
                }

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int returnvalue = bb.showSaveDialog(GUI.this);
                    if (returnvalue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = bb.getSelectedFile();
                        calc.calc(exc);
                        exc.write(selectedFile.getAbsolutePath(), calc.getresult());
                        JOptionPane.showMessageDialog(null, "Done", "Export", JOptionPane.PLAIN_MESSAGE);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Not found", "Error", JOptionPane.PLAIN_MESSAGE);
                }

            }
        });

        container.add(b);
        container.add(b2);


        class ButtonEventListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

            }
        }


    }
}
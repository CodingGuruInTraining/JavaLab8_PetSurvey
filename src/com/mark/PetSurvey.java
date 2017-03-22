package com.mark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This program generates a GUI with interactive
 * checkboxes.
 */
public class PetSurvey extends JFrame {
    private JPanel rootPanel;
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JLabel surveyResultsLabel;
    private JButton quitButton;

    private boolean dog;
    private boolean cat;
    private boolean fish;

    // Constructor.
    protected PetSurvey() {
        setContentPane(rootPanel);
        pack();
        setSize(new Dimension(350, 200));
        setTitle("Pet Survey");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        // Checkbox event listeners. Each updates a boolean variable
        // if the checkbox is checked and then updates a label's text.
        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isSelected();
                updateResults();
            }
        });
        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });
        // Quit button's event listener.
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Displays a confirmation window when clicked.
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this,
                        "Are you sure you want to quit?", "Quit",
                        JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    // Method for updating label text.
    private void updateResults() {
        // Fancy if/else statements.
        String hasDog = dog ? "one dog" : "no dogs";
        String hasCat = cat ? "one cat" : "no cats";
        String hasFish = fish ? "one fish" : "no fish";

        // Combines values in single string and adds to label.
        String results = "you have " + hasDog + " and " + hasCat + " and " + hasFish;
        surveyResultsLabel.setText(results);
    }
}

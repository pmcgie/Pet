package com.Paul_McGie;

import javafx.beans.binding.BooleanExpression;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by pmcgie on 3/22/2017.
 */
public class PetSurvey extends JFrame {
    private JPanel rootPanel;
    private JCheckBox dogCheckBox;
    private JCheckBox fishCheckBox;
    private JCheckBox catCheckBox;
    private JLabel SurveyResultsLabel;
    private JLabel PetLabel;
    private JButton quitButton;
    private boolean Fish;
    private boolean Cat;
    private boolean Dog;

    protected PetSurvey() {
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setTitle("Pet survey program");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Fish = fishCheckBox.isSelected();
                updateResults();
                System.out.println("the fish checkbox was checked or unchecked");
            }
        });
        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Dog = dogCheckBox.isSelected();
                updateResults();
                System.out.println("the dog checkbox was checked or unchecked");
            }
        });
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Cat = catCheckBox.isSelected();
                updateResults();
                System.out.println("the cat checkbox was checked or unchecked");
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are" +
                        "you sure you want to quit?","Confirm Quit",JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
        private void updateResults() {
            String hasDog = Dog ? "a dog" : "no dogs";
            String hasCat = Cat ? "a cat" : "no cats";
            String hasfish = Fish ? "a fish" : "no fishes";

            String results = "user has " + hasDog + " and " + hasCat + " and " + hasfish;
            SurveyResultsLabel.setText(results);
        }

}

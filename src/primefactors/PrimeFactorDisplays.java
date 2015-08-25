/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primefactors;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author thomas
 */
public class PrimeFactorDisplays extends JFrame {
    protected JPanel topPanel;
    private JTextArea ta  = new JTextArea("TextArea", 10, 50);
    private JTextField inputTextfield = new JTextField();
    private JTextField showFactors = new JTextField();
    private JButton submitButton;
    
    public PrimeFactorDisplays(String Title) {
        setSize(400, 400);
        setTitle(Title);
        
//      Define Button
        submitButton = new JButton("Calculate");
        submitButton.addActionListener(new CalculateFactors());
        
        topPanel = new JPanel();
        
        Container cp = getContentPane();
        cp.add(topPanel, BorderLayout.NORTH);
        
        topPanel.setLayout(new GridLayout(4,1));
        topPanel.add(new JLabel("Enter the Number to calculate (integers > 1)"));
        topPanel.add(inputTextfield);
        topPanel.add(submitButton);
        topPanel.add(showFactors);
        
    }
    
    private class CalculateFactors implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            try {
                int number = Integer.parseInt(inputTextfield.getText());
                setTitle("Factors of " + number);
                PrimeFactors calculator = new PrimeFactors(number);
                showFactors.setText(calculator.toString());
                
                
            } catch (NumberFormatException e) {
                showFactors.setText("That is not an integer you've entered");
                setTitle("Input Error");
            } catch (ArrayIndexOutOfBoundsException e) {
                showFactors.setText("Please enter an integer > 1");
                setTitle("Input Error");
            }
        }
    }
    
    
}

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
    private JLabel isPrime = new JLabel("This will say if Prime or not");
    
    public PrimeFactorDisplays(String Title) {
        setSize(400, 400);
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//      Define Button
        submitButton = new JButton("Calculate");
        submitButton.addActionListener(new CalculateFactors());
        
        topPanel = new JPanel();
        
        Container cp = getContentPane();
        cp.add(topPanel, BorderLayout.NORTH);
        
        topPanel.setLayout(new GridLayout(5,1));
        topPanel.add(new JLabel("Enter the Number to calculate (integers > 1)"));
        topPanel.add(inputTextfield);
        topPanel.add(submitButton);
        topPanel.add(showFactors);
        topPanel.add(isPrime);
       
        
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
                if(calculator.isPrime()) {
                    isPrime.setText(number + " is a prime number");
                } else {
                    isPrime.setText(number + " is NOT a prime number");
                }
                
                
            } catch (NumberFormatException e) {
                isPrime.setText("That is not an integer you've entered");
                showFactors.setText("");
                setTitle("Input Error");
            } catch (ArrayIndexOutOfBoundsException e) {
                isPrime.setText("Please enter an integer > 1");
                showFactors.setText("");
                setTitle("Input Error");
            }
        }
    }
    
    
}

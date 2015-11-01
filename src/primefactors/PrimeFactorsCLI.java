/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primefactors;

import java.util.Scanner;
/**
 *
 * @author thomas
 */
public class PrimeFactorsCLI {
    public static void main(String[] args) {
        PrimeFactors p;
        System.out.println("Please enter the number: ");
        Scanner scan = new Scanner(System.in);    
        
        p = new PrimeFactors(Long.parseLong(scan.nextLine()), false);
        // Now I want to run two threads... 
        
        // Thread 1 will initiate the calculation process.
        PrimeFactorsThreadCalculate calculator = new PrimeFactorsThreadCalculate(p);
        Thread t1 = new Thread(calculator);
        t1.start();
        // Thread 2 will monitor the calculation and send output to
        // user.

        PrimeFactorsMonitorCalculation monitor = new PrimeFactorsMonitorCalculation(p);
        Thread t2 = new Thread(monitor);
        t2.start();
        
        // Wait for calculation to complete before printing the factors
        
        try {
            t1.join();
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        p.printFactors();
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primefactors;

import java.util.*;

/** PrimeFactors is a class with for calculating the PrimeFactors of a number.
 * It is mostly for the author to play around with various features of the 
 * Java language.
 *
 * @author Thomas Bridge
 * @version v0.1
 * 
 */
public class PrimeFactors {
    // Use ArrayList to hold the factors... 
    private ArrayList<Long>factors = new ArrayList<Long>();
    private long numberToFactor;
    private long currentFactorToTest;
    private boolean completed = false;
    
    /** This constructor method takes the number n as an argument and immediately
     * calculates the factors of the number
     * 
     * @param n The number to calculate the prime factors of.
     */
    public PrimeFactors(long n) {        
        numberToFactor = n; 
        calculateFactors();
    }
    
    /** This constructor method takes the number n as an argument.  If calculateNow
     * is set to be false, it will not immediately calculate the factors which means
     * that calculate factors will need to be explicitly called.
     * 
     * @param n The number to calculate the prime factors of.
     * @param calculateNow if true, calculate the factors immediately (the same as calling with no parameter)
     */
    public PrimeFactors(long n, boolean calculateNow) {
        numberToFactor = n;
        if(calculateNow) {
            calculateFactors();
        }
    }
    
    /**
     *
     */
    public void calculateFactors() {
        long n = numberToFactor;
        currentFactorToTest =2;
        // Note - this should only run when currentFactorToTest == 2:
        
        while(n % currentFactorToTest == 0) {
            factors.add(currentFactorToTest);
            n = n / currentFactorToTest;
        }
        
        // Take this to 3.
        
        currentFactorToTest++;
        
        // Now we simply skip all even numbers > 2 as we know 
        // they are not prime.
        
        while(n>1) {
            
            if((n % currentFactorToTest) == 0) {
                factors.add(currentFactorToTest);
                n = n / currentFactorToTest;
            } else {
                currentFactorToTest+=2;
            }
        }
        completed = true;
    }

    /**
     *
     * @return
     */
    public long getNumber() {
        return numberToFactor;
    }
    
    /**
     *
     */
    public void printFactors() {
        if(completed) {
            int i;
            for(i = 0; i< factors.size(); i++) {
                System.out.print(factors.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("Calculations not done yet");
        }
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Long> getFactors() {
        return factors;
    }
    
    public long getCurrentCalculationPoint() {
        return currentFactorToTest;
    }
    
    public boolean getCalculationStatus() {
        return completed;
    }
    
    @Override
    public String toString() {
        String factorList = "";
        int i;
        for(i = 0; i< factors.size()-1; i++) {
            factorList = factorList + factors.get(i) + ", ";
        }
        factorList = factorList + factors.get(factors.size()-1);
        
        return factorList;
    }
    
    /**
     *
     * @return
     */
    public boolean isPrime() {
        if(factors.size() == 1) {
            return true;
        } else {
            return false;
        }
        
    }
}

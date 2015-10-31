/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primefactors;

import java.util.*;

/**
 *
 * @author thomas
 */
public class PrimeFactors {
    // Use ArrayList to hold the factors... 
    private ArrayList<Long>factors = new ArrayList<Long>();
    private long numberToFactor;
    
    public PrimeFactors(long n) {
        long currentFactorToTest = 2;
        numberToFactor = n;
        
        while(n > 1) {
            
            if((n % currentFactorToTest) == 0) {
                factors.add(currentFactorToTest);
                n = n / currentFactorToTest;
            } else {
                currentFactorToTest++;
            }
        }
    }
    
    public long getNumber() {
        return numberToFactor;
    }
    
    public void printFactors() {
        int i;
        for(i = 0; i< factors.size(); i++) {
            System.out.print(factors.get(i) + " ");
        }
        System.out.println();
    }
    
    public ArrayList<Long> getFactors() {
        return factors;
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
    
    public boolean isPrime() {
        if(factors.size() == 1) {
            return true;
        } else {
            return false;
        }
        
    }
}

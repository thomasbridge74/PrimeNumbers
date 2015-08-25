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
    private ArrayList<Integer>factors = new ArrayList<Integer>();
    private int numberToFactor;
    
    public PrimeFactors(int n) {
        int currentFactorToTest = 2;
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
    
    public int getNumber() {
        return numberToFactor;
    }
    
    public void printFactors() {
        int i;
        for(i = 0; i< factors.size(); i++) {
            System.out.print(factors.get(i) + " ");
        }
        System.out.println();
    }
    
    public ArrayList<Integer> getFactors() {
        return factors;
    }
}
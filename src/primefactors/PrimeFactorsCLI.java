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
        
        p = new PrimeFactors(Long.parseLong(scan.nextLine()));
        p.printFactors();
    }
}

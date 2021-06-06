package ex13.base;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 13 Solution
 *  Copyright 2021 William Weatherlow
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        App myApp = new App();
        System.out.print("What is the principal amount? ");
        float principal = myApp.readInput();
        System.out.print("What is the rate? ");
        float rate = myApp.readInput();
        System.out.print("What is the number of years? ");
        float time = myApp.readInput();
        System.out.print("What is the number of times the interest is compounded per year? ");
        float compound = myApp.readInput();

        String output = myApp.doMath(principal,rate,time,compound);
        myApp.displayOutput(output);


    }
    private float readInput(){
        return in.nextFloat();
    }

    private String doMath(float principal, float rate, float time, float compound){
        /*P(1 + r/n)^(n*t)
        Reused most of my code from ex12, just adjusted the formula and added the extra inputs.
         */
        float accrued = principal * (float)Math.pow((1+((rate/100)/compound)),(compound * time));
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return "$" + (int)principal + " invested at " + rate + "% for " + (int)time + " years compounded " + (int)compound + " times per year is $" + df.format(accrued) + ".";
    }
    private void displayOutput(String output){
        System.out.println(output);
    }

}
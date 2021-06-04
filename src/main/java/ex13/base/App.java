package ex13.base;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
Exercise 13 - Determining Compound Interest
Simple interest is something you use only when making a quick guess. Most investments use a compound interest formula, which will be much more accurate. And this formula requires you to incorporate exponents into your programs.

Write a program to compute the value of an investment compounded over time. The program should ask for the starting amount, the number of years to invest, the interest rate, and the number of periods per year to compound.

The formula you’ll use for this is A = P(1 + r/n)^(n*t) where

P is the principal amount.
r is the annual rate of interest.
t is the number of years the amount is invested.
n is the number of times the interest is compounded per year.
A is the amount at the end of the investment.
Example Output
What is the principal amount? 1500
What is the rate? 4.3
What is the number of years? 6
What is the number of times the interest is compounded per year? 4
$1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.
Constraints
Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
Ensure that fractions of a cent are rounded up to the next penny.
Ensure that the output is formatted as money.
Challenges
Ensure that all of the inputs are numeric and that the program will not let the user proceed without valid inputs.
Create a version of the program that works in reverse, so you can determine the initial amount you’d need to invest to reach a specific goal.
Implement this program as a GUI app that automatically updates the values when any value changes.
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
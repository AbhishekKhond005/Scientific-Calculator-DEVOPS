package com.calculator;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Calculator calc = new Calculator();
	Scanner sc = new Scanner(System.in);
	
	while(true) {
	    System.out.println("\nScientific Calculator");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Log");
            System.out.println("4. Power");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    System.out.print("Enter number: ");
                    double x = sc.nextDouble();
                    System.out.println("Result: "+calc.sqrt(x));
                    break;

                case 2:
                    System.out.print("Enter number: ");
                    int n = sc.nextInt();
                    System.out.println("Result: "+calc.factorial(n));
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    double l = sc.nextDouble();
                    System.out.println("Result: "+calc.ln(l));
                    break;

                case 4:
                    System.out.print("Enter base: ");
                    double a = sc.nextDouble();
                    System.out.print("Enter power: ");
                    double b = sc.nextDouble();
                    System.out.println("Result: "+calc.power(a,b));
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}

package com.calculator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nScientific Calculator");
                System.out.println("1. Square Root");
                System.out.println("2. Factorial");
                System.out.println("3. Natural Log");
                System.out.println("4. Power");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                System.out.flush();

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter number: ");
                        System.out.flush();
                        double x = sc.nextDouble();
                        System.out.println("Result: " + calc.sqrt(x));
                        break;

                    case 2:
                        System.out.print("Enter number: ");
                        System.out.flush();
                        int n = sc.nextInt();
                        System.out.println("Result: " + calc.factorial(n));
                        break;

                    case 3:
                        System.out.print("Enter number: ");
                        System.out.flush();
                        double l = sc.nextDouble();
                        System.out.println("Result: " + calc.ln(l));
                        break;

                    case 4:
                        System.out.print("Enter base: ");
                        System.out.flush();
                        double a = sc.nextDouble();
                        System.out.print("Enter power: ");
                        System.out.flush();
                        double b = sc.nextDouble();
                        System.out.println("Result: " + calc.power(a, b));
                        break;

                    case 5:
                        System.out.println("Exiting calculator. Goodbye!");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter 1-5.");
                }

            } catch (NoSuchElementException e) {
                System.out.println("\nInput stream closed. Exiting calculator.");
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine(); // clear bad input
            }
        }
    }
}

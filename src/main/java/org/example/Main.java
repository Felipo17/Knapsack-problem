package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = getValidIntInput(scanner, "Enter number of items: ", 1, Integer.MAX_VALUE);
        int seed = getValidIntInput(scanner, "Enter seed: ", 0, Integer.MAX_VALUE);
        int capacity = getValidIntInput(scanner, "Enter knapsack capacity: ", 1, Integer.MAX_VALUE);

        Problem problem = new Problem(n, seed, 1, 10);

        System.out.println("Items:");
        problem.printItems();

        Result result = problem.solve(capacity);

        System.out.println(result);
    }

    private static int getValidIntInput(Scanner scanner, String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Input must be between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next();
            }
        }
        return input;
    }
}

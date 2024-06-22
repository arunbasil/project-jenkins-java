package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Execute the main logic
        Main main = new Main();
        main.printNumbers(new int[]{4, 2, 3, 4, 5});
        main.printNames(new String[]{"Ann", "Arun", "Aidan", "Ayana"});
        main.processNamesList(Arrays.asList("Alice", "Bob", "Charlie", "David"));
    }

    // Method to print numbers
    public void printNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    // Method to print names
    public void printNames(String[] names) {
        for (String name : names) {
            System.out.println(name);
        }
    }

    // Method to process names list
    public void processNamesList(List<String> names1) {
        names1.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        names1.set(0, "Ann");

        names1.forEach(n -> {
            if (n.startsWith("B")) {
                System.out.println(n.toUpperCase());
            }
        });
    }
}

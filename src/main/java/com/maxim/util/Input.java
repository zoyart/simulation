package com.maxim.util;

import java.util.Scanner;

public class Input {
    public static String userInput(Scanner scanner, String prompt) {
        try {
            if (scanner.hasNextLine()) {
                System.out.print(prompt);
                return scanner.nextLine();
            } else {
                System.out.println("Invalid input");
                return "";
            }
        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage());
            return "";
        }
    }
}

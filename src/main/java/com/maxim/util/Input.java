package com.maxim.util;

import java.util.Scanner;

public class Input {
    public static String userInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}

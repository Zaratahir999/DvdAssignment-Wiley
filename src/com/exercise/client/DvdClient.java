package com.exercise.client;

import java.util.Scanner;

import com.exercise.presentation.DvdUserInterface;
import com.exercise.presentation.DvdUserInterfaceImpl;

public class DvdClient {
    public static void main(String[] args) {
        DvdUserInterface dvdUserInterface = new DvdUserInterfaceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            dvdUserInterface.showMenu();
            System.out.println("Enter choice:");
            int choice = scanner.nextInt();

            try {
                dvdUserInterface.performMenu(choice);
            } catch (Exception e) {
                System.out.println("Something went wrong, please try again");
                
            }
        }
    }
}

package com.matyas.springbootapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(DatabaseService databaseService) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Please select an option:");
                System.out.println("1. Add applicant");
                System.out.println("2. Update applicant");
                System.out.println("3. Delete applicant");
                System.out.println("4. List all applicants");
                System.out.println("5. Find applicant by ID");
                System.out.println("0. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the leftover newline character

                switch (choice) {
                    case 1:
                        databaseService.addApplicant();
                        break;
                    case 2:
                        System.out.print("Enter ID of applicant to update: ");
                        Long id = scanner.nextLong();
                        scanner.nextLine(); // consume the leftover newline character
                        databaseService.updateApplicant(id);
                        break;
                    case 3:
                        System.out.print("Enter ID of applicant to delete: ");
                        Long idToDelete = scanner.nextLong();
                        scanner.nextLine(); // consume the leftover newline character
                        databaseService.deleteApplicant(idToDelete);
                        break;
                    case 4:
                        databaseService.listAllApplicants();
                        break;
                    case 5:
                        System.out.print("Enter ID of applicant to find: ");
                        Long idToFind = scanner.nextLong();
                        scanner.nextLine(); // consume the leftover newline character
                        databaseService.findApplicantById(idToFind);
                        break;
                    case 0:
                        System.out.println("Exiting application...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        };
    }
}
package com.matyas.springbootapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class DatabaseService {

    private final ApplicantRepository applicantRepository;

    public DatabaseService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public void addApplicant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter information for a new applicant:");
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Date of birth (yyyy-mm-dd): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Email address: ");
        String email = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline character

        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setDateOfBirth(dateOfBirth);
        applicant.setAddress(address);
        applicant.setEmail(email);
        applicant.setAge(age);

        applicantRepository.save(applicant);
        System.out.println("New applicant saved to the database.");
    }
    public void listAllApplicants() {
        List<Applicant> applicants = applicantRepository.findAll();
        if (applicants.isEmpty()) {
            System.out.println("No applicants found.");
        } else {
            System.out.println("List of all applicants:");
            for (Applicant applicant : applicants) {
                System.out.println(applicant.toString());
            }
        }
    }

    public void findApplicantById(Long id) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(id);
        if (applicantOptional.isPresent()) {
            System.out.println("Applicant with ID " + id + ":");
            System.out.println(applicantOptional.get().toString());
        } else {
            System.out.println("Applicant with ID " + id + " not found.");
        }
    }

    public void updateApplicant(Long id) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(id);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter updated information for the applicant or leave blank line for current change:");
            System.out.print("First name [" + applicant.getFirstName() + "]: ");
            String firstName = scanner.nextLine();
            if (!firstName.isBlank()) {
                applicant.setFirstName(firstName);
            }
            System.out.print("Last name [" + applicant.getLastName() + "]: ");
            String lastName = scanner.nextLine();
            if (!lastName.isBlank()) {
                applicant.setLastName(lastName);
            }
            System.out.print("Date of birth (yyyy-mm-dd) [" + applicant.getDateOfBirth() + "]: ");
            String dateOfBirth = scanner.nextLine();
            if (!dateOfBirth.isBlank()) {
                applicant.setDateOfBirth(dateOfBirth);
            }
            System.out.print("Address [" + applicant.getAddress() + "]: ");
            String address = scanner.nextLine();
            if (!address.isBlank()) {
                applicant.setAddress(address);
            }
            System.out.print("Email address [" + applicant.getEmail() + "]: ");
            String email = scanner.nextLine();
            if (!email.isBlank()) {
                applicant.setEmail(email);
            }
            System.out.print("Age [" + applicant.getAge() + "]: ");
            String ageString = scanner.nextLine();
            if (!ageString.isBlank()) {
                int age = Integer.parseInt(ageString);
                applicant.setAge(age);
            }

            applicantRepository.save(applicant);
            System.out.println("Applicant with ID " + id + " updated.");
        } else {
            System.out.println("Applicant with ID " + id + " not found.");
        }
    }

    public void deleteApplicant(Long id) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(id);
        if (applicantOptional.isPresent()) {
            applicantRepository.deleteById(id);
            System.out.println("Applicant with ID " + id + " deleted.");
        } else {
            System.out.println("Applicant with ID " + id + " not found.");
        }
    }

}
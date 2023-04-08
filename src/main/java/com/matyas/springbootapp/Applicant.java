package com.matyas.springbootapp;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Applicant")


public class Applicant {
        @Id
        @SequenceGenerator(
                name = "applicant_sequence",
                sequenceName = "applicant_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = SEQUENCE,
                generator = "applicant_sequence"
        )
        @Column(
                name = "id",
                updatable = false
        )
        private Long id;

        @Column(
                name = "first_name",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String firstName;

        @Column(
                name = "last_name",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String lastName;

        @Column(
                name = "dateOfBirth",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String dateOfBirth;

        @Column(
                name = "adress",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String adress;

        @Column(
                name = "email",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String email;

        @Column(
                name = "age",
                nullable = false

        )
        private Integer age;

        public Applicant(Long id, String firstName, String lastName, String dateOfBirth, String adress, String email, Integer age) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.dateOfBirth = dateOfBirth;
                this.adress = adress;
                this.email = email;
                this.age = age;
        }

        public Applicant() {

        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getDateOfBirth() {
                return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
        }

        public String getAdress() {
                return adress;
        }

        public void setAdress(String adress) {
                this.adress = adress;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }


        }





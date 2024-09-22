package assignment6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Processor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by id");
            System.out.println("3. Delete a student by id");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date of birth (yyyy-MM-dd): ");
                    String dobStr = scanner.nextLine();

                    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateOfBirth = null; // Declare the dateOfBirth variable

                    try {
                        dateOfBirth = sdf.parse(dobStr);  // Convert string to Date
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
                        break;  // Exit this case if date is invalid
                    }

                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter major: ");
                    String major = scanner.nextLine();

                    // Create new Student and add to studentList
                    Student student = new Student(id, name, dateOfBirth, gpa, major);
                    studentList.addStudent(student);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter student ID to update: ");
                    String updateId = scanner.nextLine();
                    Student studentToUpdate = studentList.findStudentById(updateId);

                    if (studentToUpdate != null) {
                        System.out.println("Updating student with ID: " + updateId);

                        // Update name
                        System.out.print("Enter new name (or press Enter to keep current: " + studentToUpdate.getFullName() + "): ");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) {
                            studentToUpdate.setFullName(newName);
                        }

                        // Update date of birth
                        System.out.print("Enter new date of birth (yyyy-mm-dd) (or press Enter to keep current): ");
                        String newDobString = scanner.nextLine();
                        if (!newDobString.isEmpty()) {
                            try {
                                Date newDob = sdf.parse(newDobString);
                                studentToUpdate.setDateOfBirth(newDob);
                            } catch (ParseException e) {
                                System.out.println("Invalid date format. Keeping the current date of birth.");
                            }
                        }

                        // Update GPA
                        System.out.print("Enter new GPA (or press Enter to keep current: " + studentToUpdate.getGpa() + "): ");
                        String newGpaString = scanner.nextLine();
                        if (!newGpaString.isEmpty()) {
                            float newGpa = Float.parseFloat(newGpaString);
                            studentToUpdate.setGpa(newGpa);
                        }

                        // Update major
                        System.out.print("Enter new major (or press Enter to keep current: " + studentToUpdate.getMajor() + "): ");
                        String newMajor = scanner.nextLine();
                        if (!newMajor.isEmpty()) {
                            studentToUpdate.setMajor(newMajor);
                        }

                        System.out.println("Student with ID " + updateId + " updated successfully.");
                    } else {
                        System.out.println("Student with ID " + updateId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    System.out.println("Student deleted successfully!");
                    break;

                case 4:
                    System.out.println("Display all students");
                    studentList.displayAllStudents();
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top student details: ");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students available.");
                    }
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

package assignment6;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> studentList;

    // Constructor
    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Delete a student by ID
    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    // Find student by ID
    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println("-----------");
        }
    }

    // Find the student with the highest GPA
    public Student findTopStudent() {
        Student topStudent = null;
        for (Student student : studentList) {
            if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}

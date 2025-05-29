package models.repositories;

import java.util.ArrayList;
import java.util.List;

import models.entities.Student;

public class StudentRepository {
    private static StudentRepository instance;
    private List<Student> students;

    private StudentRepository() {
        this.students = new ArrayList<>();
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public void save(Student student) {
        students.add(student);
    }

    public void delete(Student student) {
        students.remove(student);
    }

    public void update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRegistration().equals(student.getRegistration())) {
                students.get(i).setName(student.getName());
                students.get(i).setEmail(student.getEmail());
                students.get(i).setAddress(student.getAddress());
                return;
            }
        }
    }

    public Student findByRegistration(String registration) {
        for (Student student : students) {
            if (student.getRegistration().equals(registration)) {
                return student;
            }
        }
        return null;
    }

    public Student findByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    public String findAll() {
        if (students.isEmpty()) return null;

        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.toString()).append("\n");
        }
        return sb.toString();
    }
}

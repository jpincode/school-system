package business.services;

import models.entities.Student;
import models.repositories.StudentRepository;

public class StudentService {
    private static final StudentRepository studentRepository = StudentRepository.getInstance();

    public boolean register(String registration, String name, String email, String address) {
        if (studentRepository.findByRegistration(registration) != null) return false;
        if (studentRepository.findByEmail(email) != null) return false;

        Student student = new Student(registration, name, email, address);
        studentRepository.save(student);
        return true;
    }

    public boolean delete(String registration) {
        Student student = studentRepository.findByRegistration(registration);
        if (student == null) return false;

        studentRepository.delete(student);
        return true;
    }

    public boolean update(String registration, String name, String email, String address) {
        Student student = studentRepository.findByRegistration(registration);
        if (student == null) return false;

        if(!name.isBlank() && name != student.getName()) student.setName(name);
        if(!email.isBlank() && email != student.getEmail()) student.setEmail(email);
        if(!address.isBlank() && address != student.getAddress()) student.setAddress(address);
        studentRepository.update(student);
        return true;
    }

    public String findAll() {
        return studentRepository.findAll();
    }
}

package business.services;

import models.entities.Student;
import models.repositories.ManagerRepository;

public class StudentService {
    private static final ManagerRepository managerRepository = ManagerRepository.getInstance();

    public boolean register(String registration, String name, String email, String address) {
        if (managerRepository.getStudentRepository().findByRegistration(registration) != null) return false;
        if (managerRepository.getStudentRepository().findByEmail(email) != null) return false;

        Student student = new Student(registration, name, email, address);

        managerRepository.getStudentRepository().save(student);
        return true;
    }

    public boolean delete(String registration) {
        Student student = managerRepository.getStudentRepository().findByRegistration(registration);
        if (student == null) return false;

        managerRepository.getStudentRepository().delete(student);
        return true;
    }

    public boolean update(String registration, String name, String email, String address) {
        Student student = managerRepository.getStudentRepository().findByRegistration(registration);
        if (student == null) return false;

        if (!name.isBlank() && name != student.getName()) student.setName(name);
        if (!email.isBlank() && email != student.getEmail()) student.setEmail(email);
        if (!address.isBlank() && address != student.getAddress()) student.setAddress(address);

        managerRepository.getStudentRepository().update(student);
        return true;
    }

    public String findAll() {
        return managerRepository.getStudentRepository().findAll();
    }
}

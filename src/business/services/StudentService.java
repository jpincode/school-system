package business.services;

import business.dto.StudentDTO;
import models.entities.Student;
import models.repositories.ManagerRepository;
import models.repositories.StudentRepository;

public class StudentService {
    private static final ManagerRepository managerRepository = ManagerRepository.getInstance();
    private StudentRepository studentRepository = managerRepository.getStudentRepository();

    // TODO foi adicionado StudentDTO e os parâmetros do método foram alterados
    public boolean register(StudentDTO studentDTO) {
        if (studentRepository.findByRegistration(studentDTO.getRegistration()) != null) return false;
        if (studentRepository.findByEmail(studentDTO.getEmail()) != null) return false;

        Student student = new Student(studentDTO.getRegistration(), studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAddress());

        studentRepository.save(student);
        return true;
    }

    public boolean delete(String registration) {
        Student student = studentRepository.findByRegistration(registration);
        if (student == null) return false;

        studentRepository.delete(student);
        return true;
    }

    // TODO foi adicionado StudentDTO e os parâmetros do método foram alterados
    public boolean update(StudentDTO studentDTO) {
        Student student = studentRepository.findByRegistration(studentDTO.getRegistration());
        if (student == null) return false;

        if (!studentDTO.getName().isBlank() && studentDTO.getName() != student.getName()) student.setName(studentDTO.getName());
        if (!studentDTO.getEmail().isBlank() && studentDTO.getEmail() != student.getEmail()) student.setEmail(studentDTO.getEmail());
        if (!studentDTO.getAddress().isBlank() && studentDTO.getAddress() != student.getAddress()) student.setAddress(studentDTO.getAddress());

        studentRepository.update(student);
        return true;
    }

    public String findAll() {
        return studentRepository.findAll();
    }
}

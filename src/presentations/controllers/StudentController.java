package presentations.controllers;

import business.dto.StudentDTO;
import business.services.StudentService;

public class StudentController {
    private static final StudentService studentService = new StudentService();

    public String register(String registration, String name, String email, String address) {
        if (registration == null || registration.isEmpty()) {
            return "[ERROR] - Registration cannot be empty.";
        }
        if (name == null || name.isEmpty()) {
            return "[ERROR] - Name cannot be empty.";
        }
        if (email == null || email.isEmpty()) {
            return "[ERROR] - Email cannot be empty.";
        }
        if (address == null || address.isEmpty()) {
            return "[ERROR] - Address cannot be empty.";
        }

        // TODO adicionado StudentDTO
        StudentDTO studentDTO = new StudentDTO(registration, name, email, address);

        boolean wasCreated = studentService.register(studentDTO);
        if (!wasCreated) {
            return "[ERROR] - Student with this registration or email already exists.";
        }
        return "Student registered successfully.";
    }

    public String delete(String registration, String confirmation) {
        if (confirmation.equalsIgnoreCase("N") || confirmation.isEmpty()) return "[INFO] - Student deletion cancelled.";

        if (registration == null || registration.isEmpty()) return "[ERROR] - Registration cannot be empty.";

        boolean wasDeleted = studentService.delete(registration);
        if (!wasDeleted) return "[ERROR] - Student with this registration does not exist.";
        return "Student deleted successfully.";
    }

    public String update(String registration, String name, String email, String address) {
        if (registration == null || registration.isEmpty()) return "[ERROR] - Registration cannot be empty.";

        // TODO adicionado StudentDTO
        StudentDTO studentDTO = new StudentDTO(registration, name, email, address);

        boolean wasUpdated = studentService.update(studentDTO);
        if (!wasUpdated) return "[ERROR] - Student with this registration does not exist or no changes were made.";
        return "Student updated successfully.";
    }

    public String list() {
        String result = studentService.findAll();
        if (result == null || result.isEmpty()) {
            return "[ERROR] - No students registered.";
        }
        return result;
    }
}

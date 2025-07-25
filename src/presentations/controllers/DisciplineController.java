package presentations.controllers;

import business.dto.DisciplineDTO;
import business.services.DisciplineService;

public class DisciplineController {
    private static final DisciplineService disciplineService = new DisciplineService();

    public String register(String name, String code, String workload) {
        if(name == null || name.isEmpty()) {
            return "[ERROR] - Discipline name cannot be empty.";
        }
        if(code == null || code.isEmpty()) {
            return "[ERROR] - Discipline code cannot be empty.";
        }
        if(workload == null || workload.isEmpty()) {
            return "[ERROR] - Discipline workload cannot be empty.";
        }

        // TODO adicionado DisciplineDTO
        DisciplineDTO disciplineDTO = new DisciplineDTO(name, code, workload);
        
        boolean wasCreated = disciplineService.registerDiscipline(disciplineDTO);
        if(!wasCreated) return "[ERROR] - Discipline with this code or name already exists.";
        return "Discipline registered successfully.";
    }

    public String enrollStudent(String code, String studentRegistration) {
        if(code == null || code.isEmpty()) return "[ERROR] - Discipline code cannot be empty.";
        if(studentRegistration == null || studentRegistration.isEmpty()) return "[ERROR] - Student registration cannot be empty.";
        
        boolean wasEnrolled = disciplineService.enrollStudent(code, studentRegistration);
        if(!wasEnrolled) return "[ERROR] - Discipline or student does not exist.";
        return "Student enrolled successfully.";
    }

    public String unenrollStudent(String code, String studentRegistration) {
        if(code == null || code.isEmpty()) return "[ERROR] - Discipline code cannot be empty.";
        if(studentRegistration == null || studentRegistration.isEmpty()) return "[ERROR] - Student registration cannot be empty.";
        boolean wasUnenrolled = disciplineService.unenrollStudent(code, studentRegistration);
        if(!wasUnenrolled) return "[ERROR] - Discipline or student does not exist.";
        return "Student unenrolled successfully.";
    }

    public String delete(String code, String confirmation) {
        if(confirmation.equalsIgnoreCase("N") || confirmation.isEmpty()) return "[INFO] - Discipline deletion cancelled.";

        if(code == null || code.isEmpty()) return "[ERROR] - Discipline code cannot be empty.";
        
        boolean wasDeleted = disciplineService.delete(code);
        if(!wasDeleted) return "[ERROR] - Discipline with this code does not exist.";
        return "Discipline deleted successfully.";
    }

    public String update(String name, String code, String workload) {
        if(code == null || code.isEmpty()) return "[ERROR] - Discipline code cannot be empty.";
        
        // TODO adicionado DisciplineDTO
        DisciplineDTO disciplineDTO = new DisciplineDTO(name, code, workload);

        boolean wasUpdated = disciplineService.update(disciplineDTO);
        if(!wasUpdated) return "[ERROR] - Discipline with this code does not exist.";
        return "Discipline updated successfully.";
    }

    public String list() {
        String result = disciplineService.findAll();
        if(result == null || result.isEmpty()) {
            return "[ERROR] - No disciplines registered.";
        }
        return result;
    }
}

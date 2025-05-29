package presentations.controllers;

import business.services.DisciplineService;

public class DisciplineController {
    private DisciplineService disciplineService = new DisciplineService();

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
        
        boolean wasCreated = disciplineService.registerDiscipline(name, code, workload);
        if(!wasCreated) return "[ERROR] - Discipline with this code or name already exists.";
        return "Discipline registered successfully.";
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
        
        boolean wasUpdated = disciplineService.update(name, code, workload);
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

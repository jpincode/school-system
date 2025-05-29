package presentations.views;

import business.services.IOService;
import presentations.controllers.DisciplineController;
import presentations.controllers.StudentController;

public class DeleteView {
    private IOService ioService = new IOService();
    private DisciplineController disciplineController = new DisciplineController();
    private StudentController studentController = new StudentController();

    public void showDeleteDisciplineMenu() {
        ioService.print("--------------- DELETE DISCIPLINE ---------------");
        String code = ioService.read("Discipline code to delete: ");
        String confirmation = ioService.read("Are you sure you want to delete this discipline? (y/N): ");
        String result = disciplineController.delete(code, confirmation);
        ioService.print(result);
    }

    public void showDeleteStudentMenu() {
        ioService.print("--------------- DELETE STUDENT ---------------");
        String registration = ioService.read("Student registration to delete: ");
        String confirmation = ioService.read("Are you sure you want to delete this student? (y/N): ");
        String result = studentController.delete(registration, confirmation);
        ioService.print(result);
    }

    public void showUnenrollStudentMenu() {
        ioService.print("--------------- UNENROLL STUDENT FROM DISCIPLINE ---------------");
        String code = ioService.read("Discipline code: ");
        String registration = ioService.read("Student registration: ");
        String result = disciplineController.unenrollStudent(code, registration);
        ioService.print(result);
    }
}

package presentations.views;

import business.services.IOService;
import presentations.controllers.DisciplineController;
import presentations.controllers.StudentController;

public class UpdateView {
    private IOService ioService = new IOService();
    private DisciplineController disciplineController = new DisciplineController();
    private StudentController studentController = new StudentController();

    public void showUpdateDisciplineMenu() {
        ioService.print("--------------- UPDATE DISCIPLINE ---------------");
        ioService.print("If you do not want to change any item below, leave it blank.");
        String code = ioService.read("Discipline code to update: ");
        String name = ioService.read("New discipline name: ");
        String workload = ioService.read("New discipline workload: ");
        String result = disciplineController.update(name, code, workload);
        ioService.print(result);
    }

    public void showUpdateStudentMenu() {
        ioService.print("--------------- UPDATE STUDENT ---------------");
        ioService.print("If you do not want to change any item below, leave it blank.");
        String registration = ioService.read("Student registration to update: ");
        String name = ioService.read("New student name: ");
        String email = ioService.read("New student email: ");
        String address = ioService.read("New student address: ");
        String result = studentController.update(registration, name, email, address);
        ioService.print(result);
    }
}

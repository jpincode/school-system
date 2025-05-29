package presentations.views;

import business.services.IOService;
import presentations.controllers.DisciplineController;
import presentations.controllers.StudentController;

public class RegisterView {
    private IOService ioService = new IOService();
    private DisciplineController disciplineController = new DisciplineController();
    private StudentController studentController = new StudentController();

    public void showRegisterDisciplineMenu() {
        ioService.print("--------------- REGISTER DISCIPLINE ---------------");
        String name = ioService.read("Discipline name: ");
        String code = ioService.read("Discipline code: ");
        String workload = ioService.read("Discipline workload: ");
        String result = disciplineController.register(name, code, workload);
        ioService.print(result);
    }

    public void showRegisterStudentMenu() {
        ioService.print("--------------- REGISTER STUDENT ---------------");
        String registration = ioService.read("Student registration: ");
        String name = ioService.read("Student name: ");
        String email = ioService.read("Student email: ");
        String address = ioService.read("Student address: ");
        String result = studentController.register(registration, name, email, address);
        ioService.print(result);
    }

    public void showEnrollStudentMenu() {
        ioService.print("--------------- ENROLL STUDENT IN DISCIPLINE ---------------");
        String code = ioService.read("Discipline code: ");
        String registration = ioService.read("Student registration: ");
        String result = disciplineController.enrollStudent(code, registration);
        ioService.print(result);
    }
}

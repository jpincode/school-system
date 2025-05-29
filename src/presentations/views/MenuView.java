package presentations.views;

import business.services.IOService;
import presentations.controllers.DisciplineController;
import presentations.controllers.StudentController;

public class MenuView {
    private IOService ioService = new IOService();
    private DisciplineController disciplineController = new DisciplineController();
    private StudentController studentController = new StudentController();


    // Method to show the main menu
    public void showMainMenu() {
        ioService.print("--------------- SCHOOL SYSTEM ---------------");
        ioService.print("1 - Register Discipline");
        ioService.print("2 - Register Student");
        ioService.print("3 - Enroll Student in Discipline");
        ioService.print("4 - Delete Discipline");
        ioService.print("5 - Delete Student");
        ioService.print("6 - Unenroll Student from Discipline");
        ioService.print("7 - Update Discipline");
        ioService.print("8 - Update Student");
        ioService.print("9 - List");
        ioService.print("0 - Exit");
        String option = ioService.read("Choose an option: ");

        switch(option) {
            case "0" -> {
                ioService.print("Exiting the application. Goodbye!");
                System.exit(0);
            }
            case "1" -> showRegisterDisciplineMenu();
            case "2" -> showRegisterStudentMenu();
            
            case "4" -> showDeleteDisciplineMenu();
            case "5" -> showDeleteStudentMenu();
            
            case "7" -> showUpdateDisciplineMenu();
            case "8" -> showUpdateStudentMenu();
            case "9" -> showListMenu();
            default -> ioService.print("Invalid option. Please try again.");
        }
    }

    // Methods to show the register menus

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

    // Methods to show the delete menus

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

    // Methods to show the update menus

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

    // Methods to show the list menu

    public void showListMenu() {
        ioService.print("--------------- LIST MENU ---------------");
        ioService.print("1 - List Disciplines");
        ioService.print("2 - List Students");
        ioService.print("3 - List Enrollments");
        ioService.print("0 - Back to Main Menu");
        String option = ioService.read("Choose an option: ");
        switch(option) {
            case "0" -> showMainMenu();
            case "1" -> showListDisciplines();
            case "2" -> showListStudents();
            default -> ioService.print("Invalid option. Please try again.");
        }
    }

    public void showListDisciplines() {
        ioService.print("--------------- LIST OF DISCIPLINES ---------------");
        String result = disciplineController.list();
        ioService.print(result);
    }

    public void showListStudents() {
        ioService.print("--------------- LIST OF STUDENTS ---------------");
        String result = studentController.list();
        ioService.print(result);
    }
}

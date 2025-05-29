package presentations.views;

import business.services.IOService;
import presentations.controllers.DisciplineController;
import presentations.controllers.StudentController;

public class ListView {
    private IOService ioService = new IOService();
    private DisciplineController disciplineController = new DisciplineController();
    private StudentController studentController = new StudentController();
    private static MenuView menuView = new MenuView();

    public void showListMenu() {
        ioService.print("--------------- LIST MENU ---------------");
        ioService.print("1 - List Disciplines");
        ioService.print("2 - List Students");
        ioService.print("0 - Back to Main Menu");
        String option = ioService.read("Choose an option: ");
        switch(option) {
            case "0" -> menuView.showMainMenu();
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

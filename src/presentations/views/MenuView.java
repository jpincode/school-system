package presentations.views;

import business.services.IOService;

public class MenuView {
    private IOService ioService = new IOService();
    private ListView listView = new ListView();
    private RegisterView registerView = new RegisterView();
    private DeleteView deleteView = new DeleteView();
    private UpdateView updateView = new UpdateView();


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
            case "1" -> registerView.showRegisterDisciplineMenu();
            case "2" -> registerView.showRegisterStudentMenu();
            case "3" -> registerView.showEnrollStudentMenu();
            case "4" -> deleteView.showDeleteDisciplineMenu();
            case "5" -> deleteView.showDeleteStudentMenu();
            case "6" -> deleteView.showUnenrollStudentMenu();
            case "7" -> updateView.showUpdateDisciplineMenu();
            case "8" -> updateView.showUpdateStudentMenu();
            case "9" -> listView.showListMenu();
            default -> ioService.print("[ERROR] - Invalid option. Please try again.");
        }
    }
}

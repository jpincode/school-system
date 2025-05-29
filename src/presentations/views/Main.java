package presentations.views;

public class Main {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        while (true) {
            menuView.showMainMenu();
            // Assuming the user can exit the application from the main menu
            // If you want to implement an exit option, you can add a condition to break the loop
        }
    }
}

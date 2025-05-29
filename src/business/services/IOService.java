package business.services;

import java.util.Scanner;

public class IOService {
    private Scanner scanner = new Scanner(System.in);

    public <Text> void print(Text text) {
        System.out.println(text);
    }

    public <Text> void print(Text text, boolean newLine) {
        if (!newLine) {
            System.out.print(text);
        }
    }

    public <Text> String read(Text prompt) {
        this.print(prompt, false);
        return scanner.nextLine();
    }

    public <Text> void printf(Text format, Object ... args) {
        System.out.printf(format.toString(), args);
    }

    public <Text> String readf(Text prompt, Object ... args) {
        this.printf(prompt, args);
        return scanner.nextLine();
    }
}

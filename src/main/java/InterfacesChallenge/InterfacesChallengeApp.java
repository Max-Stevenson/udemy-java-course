package InterfacesChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfacesChallengeApp {
    public static void main(String[] args) {
        Player player = new Player("Max", 100, 10, "Sword");
        System.out.println(player.toString());

        player.setHitPoints(200);
        System.out.println(player);
        saveObject(player);
        loadObject(player);
        System.out.println(player);
    }

    static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose \n" +
                "1: Enter string \n" +
                "0: Quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(IsSavable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device.");
        }
    }

    public static void loadObject(IsSavable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}

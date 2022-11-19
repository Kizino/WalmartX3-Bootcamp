import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FindingList {
    public FindingList() throws InterruptedException {
        Thread.sleep(500);

        System.out.println("Welcome Back!");

        String data[] = {"rock", "weird rock", "smooth rock", "not rock"};

        System.out.println("Everything downloaded! Data:");
        Arrays.stream(data).forEach(System.out::println);

        System.out.println("\nThere is a non rock in the list. Proceed with removal..." +
                "\nRemoval succeeded! Data:");
        Arrays.stream(data).filter(item -> !item.equalsIgnoreCase("not rock")).forEach(System.out::println);

        System.out.println("\nPerfect!");
        System.out.println("\nLoading fossil data...");
        Thread.sleep(1000);

        HashMap<String, String> fossils = new HashMap<>();
        fossils.put("Bird Fossil", "The fossil has wings implying it was capable of flight");
        fossils.put("Fish Fossil", "The fossil is vaguely fish shaped implies there was once water");
        fossils.put("Tooth Fossil", "The tooth from an unknown fossil");

        System.out.println("Fossil data downloaded!");
        System.out.println("Which of the fossils would you like to learn more about? (Bird, Fish or Tooth)");

        Scanner input = new Scanner(System.in);

        switch (input.nextLine().toLowerCase()){
            case "bird":
                System.out.println("->" + fossils.get("Bird Fossil"));
                break;
            case "fish":
                System.out.println("->" + fossils.get("Fish Fossil"));
                break;
            case "tooth":
                System.out.println("->" + fossils.get("Tooth Fossil"));
                break;
            default:
                System.out.println("->The fossil you are trying to learn about is not in system");
        }

        Thread.sleep(700);

        HashSet<String> supplies = new HashSet<>();
        supplies.add("candies");
        supplies.add("water");
        supplies.add("headset");

        System.out.println("Supplies List:");
        supplies.stream().forEach(System.out::println);
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string:");
        String boringString = scanner.nextLine();

        System.out.println("Enter the start indexes (comma separated):");
        String sIndexesInput = scanner.nextLine();
        List<Integer> sIndexes = parseIndexes(sIndexesInput);

        System.out.println("Enter the end indexes (comma separated):");
        String eIndexesInput = scanner.nextLine();
        List<Integer> eIndexes = parseIndexes(eIndexesInput);

        StringFunifier funifier = new StringFunifier(boringString, sIndexes, eIndexes);
        String funnyString = funifier.getFunnyString();
        System.out.println(funnyString);
    }

    private static List<Integer> parseIndexes(String input) {
        List<Integer> indexes = new ArrayList<>();
        String[] parts = input.split(",");
        for (String part : parts) {
            indexes.add(Integer.parseInt(part.trim()));
        }
        return indexes;
    }*/
            String boringString = "ccchHJKkklmlmmml";
            List<Integer> startIndexes = List.of(1, 5, 7, 11, 13);
            List<Integer> endIndexes = List.of(3, 5, 10, 12, 14);
            List<String> funOperations = List.of("REVERSE", "UPPERCASE", "SORT", "LOWERCASE", "COMPRESSION");

            StringFunifier funifier = new StringFunifier(boringString, startIndexes, endIndexes, funOperations);
            System.out.println("Fun Ranges: " + funifier.getFunRanges());
            System.out.println("Funny String: " + funifier.getFunnyString());
        }
}
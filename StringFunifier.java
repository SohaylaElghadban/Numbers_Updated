import java.util.*;

public class StringFunifier {
    private String boringString;
    private List<Integer> start;
    private List<Integer> end;
    private List<String> funOperations;

    public StringFunifier(String boringString, List<Integer> start, List<Integer> end, List<String>  funOperations) {
        this.boringString = boringString;
        this.start = start;
        this.end = end;
        this.funOperations = funOperations;
    }
    public String getFunRanges() {
        StringBuilder result = new StringBuilder();
        int previousEnd = 0;

        for (int i = 0; i < start.size(); i++) {
            result.append(boringString, previousEnd, start.get(i));
            result.append('(').append(boringString, start.get(i), end.get(i) + 1).append(')');
            previousEnd = end.get(i) + 1;
        }

        result.append(boringString.substring(previousEnd));
        return result.toString();
    }

    public String getFunnyString() {
        StringBuilder result = new StringBuilder(boringString);

        for (int i = 0; i < start.size(); i++) {
            int start_ = start.get(i);
            int end_ = end.get(i) + 1;
            String operation = funOperations.get(i);
            String substring = result.substring(start_, end_);

            switch (operation.toUpperCase()) {
                case "REVERSE":
                    substring = new StringBuilder(substring).reverse().toString();
                    break;
                case "UPPERCASE":
                    substring = substring.toUpperCase();
                    break;
                case "LOWERCASE":
                    substring = substring.toLowerCase();
                    break;
                case "COMPRESSION":
                    substring = compress(substring);
                    break;
                case "SORT":
                    char[] chars = substring.toCharArray();
                    List<Character> charList = new ArrayList<>();
                    for (char c : chars) {
                        charList.add(c);
                    }
                    Collections.sort(charList);
                    StringBuilder sortedString = new StringBuilder();
                    for (char c : charList) {
                        sortedString.append(c);
                    }
                    substring = sortedString.toString();
                    break;
            }
            result.replace(start_, end_, substring);
        }

        return result.toString();
    }
    private String compress(String s) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        compressed.append(s.charAt(s.length() - 1)).append(count);
        return compressed.toString();
    }

}

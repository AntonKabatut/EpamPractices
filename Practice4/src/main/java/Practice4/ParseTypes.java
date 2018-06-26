package Practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseTypes {

    private static final String INPUT = "/home/saint_satan/IdeaProjects/Practice4/src/main/java/part3.txt";

    public static void main(String[] args) {
        try {
            readConsole();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readConsole() throws FileNotFoundException {
        String s;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            s = scanner.nextLine();
            if (s.equals("stop")) {
                break;
            }
            match(s);
        }
    }

    public static StringBuilder match(String type) throws FileNotFoundException {
        String str = read(INPUT);
        StringBuilder stringBuilder = null;
        switch (type) {
            case "String":
                stringBuilder = letters(str, type);
                break;
            case "char":
                stringBuilder = letters(str, type);
                break;
            case "int":
                stringBuilder = numbers(str, type, "(\\.\\d+)|(\\d+\\.\\d+)|(\\d+)");
                break;
            case "double":
                stringBuilder = numbers(str, type, "(\\.\\d+)|(\\d+\\.\\d+)");
                break;
        }
        if (stringBuilder != null) {
            stringBuilder.append(System.lineSeparator())
                    .append("-------------------------")
                    .append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
        return stringBuilder;
    }

    private static String read(String path) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(new File(path), "UTF-8");
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    private static StringBuilder letters(String str, String type) {

        StringBuilder stringBuilder = new StringBuilder("-------------------------");
        stringBuilder.append(System.lineSeparator());
        Pattern pattern = Pattern.compile("\\w+");
        Pattern helpPattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(str);
        Matcher helpMatcher;
        while (matcher.find()) {
            String result = matcher.group(0);
            helpMatcher = helpPattern.matcher(result);
            if (helpMatcher.find()) {
                String s = helpMatcher.group(0);
                if (type.equals("String")) {
                    if (s.length() == 1) {
                        continue;
                    }
                } else {
                    if (s.length() > 1) {
                        continue;
                    }
                }
                stringBuilder.append(helpMatcher.group(0)).append(" ");
            }
        }

        return stringBuilder;

    }

    private static StringBuilder numbers(String str, String type, String regExpression) {
        StringBuilder stringBuilder = new StringBuilder("-------------------------");
        stringBuilder.append(System.lineSeparator());
        Pattern intPattern = Pattern.compile(regExpression);
        Matcher intMatcher = intPattern.matcher(str);
        while (intMatcher.find()) {
            String result = intMatcher.group(0);
            if (type.equals("int")) {
                if (result.contains(".")) {
                    continue;
                }
            }
            stringBuilder.append(result).append(" ");
        }
        return stringBuilder;
    }

}

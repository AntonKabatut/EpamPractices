package Practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsTransformation {

    private static final String INPUT_FILE = "/home/saint_satan/IdeaProjects/Practice4/src/part1.txt";

    public static void main(String[] args) {
        System.out.println(check());
    }

    private static String check() {
        StringBuilder stringBuilder = new StringBuilder();
        String text = null;
        try {
            text = readFile(INPUT_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(text);
        Pattern pattern = Pattern.compile("(?ui)([a-z]*)([а-я]*)");
        Matcher matcher;
        for (String st : text.split(System.lineSeparator())) {
            matcher = pattern.matcher(st);
            while (matcher.find()) {
                if (matcher.group(0).equals("")) {
                    continue;
                }
                if (matcher.group(0).length() > 3) {
                    stringBuilder.append((matcher.group(0)).toUpperCase()).append(" ");
                } else {
                    stringBuilder.append(matcher.group(0)).append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    private static String readFile(String path) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new File(path), "UTF-8");
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}

package Practice3;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    private static final String INPUT_FILE = "/home/saint_satan/IdeaProjects/EpamPractices/Practice3/src/Practice3/resources/input.txt";
    private static final String INPUT_FILE1 = "/home/saint_satan/IdeaProjects/EpamPractices/Practice3/src/Practice3/resources/input1.txt";
    private static final String INPUT_FILE2 = "/home/saint_satan/IdeaProjects/EpamPractices/Practice3/src/Practice3/resources/input2.txt";

    private static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "UTF-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.out.println("====Source Data");
        System.out.println(getInput(INPUT_FILE));
        System.out.println();

        System.out.println("====ConvertInputInf");
        ConvertInputInf.main(new String[]{getInput(INPUT_FILE)});

        System.out.println("====WordsLength");
        WordsLength.main(new String[]{getInput(INPUT_FILE1)});

        System.out.println("====UppercaseTranslation");
        UppercaseTranslation.main(new String[]{getInput(INPUT_FILE2)});

        System.out.println("====HashingInf");
        HashingInf.main(null);

        System.out.println("====RomanNumerals");
        RomanNumerals.main(null);

    }

}


package Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UppercaseTranslation {

    public static void main(String[] args) {
        System.out.println(convert(args[0]));
    }

    private static String convert(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = input.split(System.lineSeparator());
        Pattern pattern = Pattern.compile("(?iu)([a-z]*)");
        Matcher matcher;

        for (String str : arr) {
            matcher = pattern.matcher(str);
            while (matcher.find()) {
                String s = matcher.group(0);
                if (!s.equals("")) {
                    char c = s.charAt(0);
                    String k = s.replace(c, Character.toUpperCase(c));
                    stringBuilder.append(k).append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

}

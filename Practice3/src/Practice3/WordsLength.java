package Practice3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsLength {

    public static void main(String[] args) {
        System.out.println(convert(args[0]));
    }

    private static String convert(String input) {

        Pattern pattern = Pattern.compile("(?iu)([a-z]*)");
        Matcher matcher;
        String[] arr = input.split(System.lineSeparator());
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (String str : arr) {
            matcher = pattern.matcher(str);
            while (matcher.find()) {
                if (matcher.group(0).equals("")) {
                    continue;
                }
                list.add(matcher.group(0));
            }
        }

        list.sort(Comparator.comparingInt(String::length));
        int min = list.get(0).length();
        int max = list.get(list.size() - 1).length();

        Set<String> set = new LinkedHashSet<>(list);
        stringBuilder.append("Min: ");

        for (String st : set) {
            if (st.length() == min) {
                stringBuilder.append(st).append(", ");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        stringBuilder.append(System.lineSeparator()).append("Max: ");
        for (String st : set) {
            if (st.length() == max) {
                stringBuilder.append(st).append(", ");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

}

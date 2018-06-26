package Practice3;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertInputInf {


    public static void main(String[] args) {
        System.out.println("==Convert1");
        System.out.println(convert1(args[0]));
        System.out.println("==Convert2");
        System.out.println(convert2(args[0]));
        System.out.println("==Convert3");
        System.out.println(convert3(args[0]));
        System.out.println("==Convert4");
        System.out.println(convert4(args[0]));
    }

    private static String convert1(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = input.split(System.lineSeparator());
        for (int j = 1; j < arr.length; j++) {
            String[] a = arr[j].split(";");
            for (int i = 0; i < a.length; i++) {
                stringBuilder.append(a[i]).append("==>").append(a[i += 2]).append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    private static String convert2(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = input.split(System.lineSeparator());
        for (int j = 1; j < arr.length; j++) {
            String[] a = arr[j].split(";");
            for (int i = 0; i < a.length; i++) {
                String[] f = a[i + 1].split(" ");
                stringBuilder.append(f[1]).
                        append(" ").
                        append(f[0]).
                        append(" (email: ").
                        append(a[i += 2]).
                        append(")").
                        append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    private static String convert3(String input) {
        Pattern pattern = Pattern.compile("(?i)(?<=@)(.*)");
        Matcher matcher;
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> set = new HashSet<>();

        String[] arr = input.split(System.lineSeparator());
        for (String str : arr) {
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                set.add(matcher.group(0));
            }
        }

        for (String str : set) {
            stringBuilder.append(str).append(" ==> ");
            for (int i = 1; i < arr.length; i++) {
                matcher = pattern.matcher(arr[i]);
                if (matcher.find()) {
                    if (str.equals(matcher.group(0))) {
                        stringBuilder.append(arr[i].split(";")[0]).append(", ");
                    }
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    private static String convert4(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = input.split(System.lineSeparator());
        for (int i = 1; i < arr.length; i++) {
            double password = Math.random() * 10000;
            int intPassword;
            if (password < 1000) {
                password *= 10;
                intPassword = (int) password;
            } else intPassword = (int) password;

            stringBuilder.append(arr[i]).append(";").append(String.valueOf(intPassword)).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}

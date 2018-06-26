package Practice1;

import java.util.*;

public class Numbering {

    private static Map<Integer, String> alphabet = new TreeMap<>();

    static {
        int count = 1;
        for (int i = 65; i < 91; i++) {
            alphabet.put(count, String.valueOf((char) i));
            count++;
        }
    }

    public static void main(String[] args) {
        System.out.println("ZZZ" + ">>" + chars2digits("ZZZ") + ">>" + digits2chars(chars2digits("ZZZ")));
        System.out.println("AAA" + ">>" + chars2digits("AAA") + ">>" + digits2chars(chars2digits("AAA")));
        System.out.println("BA" + ">>" + chars2digits("BA") + ">>" + digits2chars(chars2digits("BA")));
        System.out.println("AAA" + ">>" + nextChars("AAA"));
        System.out.println("ZZ" + ">>" + nextChars("ZZ"));
    }


    private static int chars2digits(String number) {
        List<Integer> list = new ArrayList<>();
        Integer result = 0;
        char[] arr = number.toCharArray();
        Set set = alphabet.entrySet();

        for (char el : arr) {
            for (Object aSet : set) {
                Map.Entry mapEntry = (Map.Entry) aSet;
                if (mapEntry.getValue().equals(String.valueOf(el))) {
                    list.add((Integer) mapEntry.getKey());
                }
            }
        }

        if (arr.length == 1) {
            result = list.get(0);
        } else {
            for (int i = 0; i < list.size() - 1; ) {
                if (i < 1) result += list.get(i);
                result *= 26;
                result += list.get(++i);
            }
        }

        return result;
    }

    private static String digits2chars(int number) {
        StringBuilder result = new StringBuilder();
        List<String> resultList = new ArrayList<>();

        if (number < 27) {
            result = new StringBuilder(alphabet.get(number));
        } else {
            String firstLine = null;
            String secondLine = null;

            while (secondLine == null || firstLine == null) {
                int x = number % 26;
                int y = number / 26;

                if (x == 0) {
                    firstLine = "Z";
                    secondLine = alphabet.get((number - 1) / 26);
                    number = y - 1;
                } else {
                    firstLine = alphabet.get(x);
                    secondLine = alphabet.get(y);
                    number = y;
                }

                if (secondLine == null) {
                    resultList.add(firstLine);
                } else {
                    resultList.add(firstLine);
                    resultList.add(secondLine);
                }
            }

            for (int i = resultList.size() - 1; i >= 0; i--) {
                result.append(resultList.get(i));
            }
        }
        return result.toString();
    }

    private static String nextChars(String number) {
        String result;
        int intermediateResult = chars2digits(number);
        result = digits2chars(++intermediateResult);
        return result;
    }

}

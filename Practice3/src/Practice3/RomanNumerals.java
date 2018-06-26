package Practice3;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RomanNumerals {

    private static final TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
    }

    public static void main(String[] args) {
//        System.out.println("1"+"==>"+decimal2Roman(1)+"==>"+roman2Decimal(decimal2Roman(1)));
//        System.out.println("2"+"==>"+decimal2Roman(2)+"==>"+roman2Decimal(decimal2Roman(2)));
//        System.out.println("3"+"==>"+decimal2Roman(3)+"==>"+roman2Decimal(decimal2Roman(3)));
//        System.out.println("4"+"==>"+decimal2Roman(4)+"==>"+roman2Decimal(decimal2Roman(4)));
//        System.out.println("5"+"==>"+decimal2Roman(5)+"==>"+roman2Decimal(decimal2Roman(5)));
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + "==>" + decimal2Roman(i) + "==>" + roman2Decimal(decimal2Roman(i)));
        }
    }

    private static String decimal2Roman(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] setKeys = map.keySet().toArray();
        Object[] setValues = map.values().toArray();
        for (int i = setValues.length - 1; i >= 0; i--) {
            while (x >= (int) setKeys[i]) {
                stringBuilder.append(setValues[i]);
                x -= (int) setKeys[i];
            }
        }

        return stringBuilder.toString();
    }

    private static int roman2Decimal(String romanNumeral) throws NumberFormatException {

        Set set = map.entrySet();

        int integerValue = 0;
        int last = 500;

        for (int i = 0; i < romanNumeral.length(); i++) {
            char ch = romanNumeral.charAt(i);
            int number = 0;
            for (Object aSet : set) {
                Map.Entry mapEntry = (Map.Entry) aSet;
                if (mapEntry.getValue().equals(String.valueOf(ch))) {
                    number = (int) mapEntry.getKey();
                }
            }
            if (number == 0) {
                throw new NumberFormatException("Invalid format");
            }
            if (last < number) {
                if (number > 10) {
                    number = number - last - 10;
                } else number = number - last - 1;
            }
            integerValue += number;
            last = number;
        }

        return integerValue;
    }

}

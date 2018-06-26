package service;

public class CountingService {

    public static int counting(String number1, String number2, String operation) {

        int result = 0;

        switch (operation) {
            case "-":
                result = Integer.parseInt(number1) - Integer.parseInt(number2);
                break;
            case "+":
                result = Integer.parseInt(number1) + Integer.parseInt(number2);
                break;
        }
        return result;
    }

}

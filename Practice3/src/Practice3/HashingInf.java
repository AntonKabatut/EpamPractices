package Practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingInf {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("password", "SHA-256"));
        System.out.println(hash("passwort", "MD5"));
        System.out.println(hash("passworr", "SHA-512"));
    }

    private static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        StringBuilder stringBuilder = new StringBuilder();
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();


        stringBuilder.append("[");
        for (byte b : hash) {
            stringBuilder.append(toHex(b)).append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private static String toHex(byte byteNumber) {
        String s = Integer.toBinaryString(byteNumber);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();

        if (s.length() > 8) {
            String s1 = s.substring(s.length() - 8, s.length());
            stringBuilder.append(s1);
        } else if (s.length() < 8) {
            for (int i = 0; i < 8 - s.length(); i++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(s);
        } else {
            stringBuilder.append(s);
        }

        String[] arr = new String[]{stringBuilder.substring(0, 4), stringBuilder.substring(4, 8)};

        for (String binaryStr : arr) {
            int decimal = Integer.parseInt(binaryStr, 2);
            String hexStr = Integer.toString(decimal, 16);
            resultBuilder.append(hexStr.toUpperCase());
        }
        return resultBuilder.toString();
    }

}

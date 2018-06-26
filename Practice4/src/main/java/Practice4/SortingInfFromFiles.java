package Practice4;

import java.io.*;
import java.util.Scanner;

public class SortingInfFromFiles {

    private static final String INPUT_FILE = "/home/saint_satan/IdeaProjects/Practice4/src/part2.txt";
    private static final String OUTPUT_FILE = "/home/saint_satan/IdeaProjects/Practice4/src/part2_sorted.txt";

    public static void main(String[] args) throws IOException {
        int[] arr = fillArr();

        writeFile(intToStr(arr), INPUT_FILE);

        String st = readFile(INPUT_FILE);

        writeFile(intToStr(sortArr(strToInt(st))), OUTPUT_FILE);

        System.out.println("input==> " + readFile(INPUT_FILE));
        System.out.println("output==> " + readFile(OUTPUT_FILE));
    }

    private static String readFile(String file) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(new File(file), "UTF-8");
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static void writeFile(String text, String path) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(path));
        br.write(text);
        br.close();
    }

    private static int[] fillArr() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            double decimal = Math.random();
            int number = (int) (decimal * 10);
            arr[i] = number;
        }
        return arr;
    }

    public static int[] sortArr(int[] arr) {
        int j;
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
        }
        return arr;
    }

    private static String intToStr(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int x : arr) {
            stringBuilder.append(x).append(" ");
        }
        return stringBuilder.toString();
    }

    private static int[] strToInt(String str) {
        int count = 0;
        String[] ar = str.split(" ");
        int[] arr = new int[ar.length - 1];
        for (String s : ar) {
            if (s.equals(System.lineSeparator())) {
                continue;
            }
            arr[count] = Integer.parseInt(s);
            count++;
        }
        return arr;
    }

}

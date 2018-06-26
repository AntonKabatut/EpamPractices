package Practice4;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleWork {

	public static void main(String[] args) {
		try {
			readConsole();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void readConsole() throws FileNotFoundException {
		String s;
		Scanner scanner=new Scanner(System.in);
		while (true){
			s=scanner.nextLine();
			if (s.equals("stop")){
				break;
			}
			match(s);
		}
	}

	public static String match(String s) {
		String[] pair=s.split(" ");
		Locale locale;
		ResourceBundle resourceBundle;
		String word;
		switch (pair[1]){
			case "ru":
				locale=new Locale("ru","RU");
				resourceBundle=ResourceBundle.getBundle("resources",locale);
				word=resourceBundle.getString(pair[0]);
				System.out.println(word);
				return word;
			case "en":
				locale=new Locale("en");
				resourceBundle=ResourceBundle.getBundle("resources",locale);
				word=resourceBundle.getString(pair[0]);
				System.out.println(word);
				return word;
		}
		return null;
	}

}

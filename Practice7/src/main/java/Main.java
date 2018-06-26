import db.DBManager;

import java.util.List;

public class Main {

    private static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {

        DBManager dbManager = DBManager.getInstance();

        // Part 1
        dbManager.insertUser("polly");
        dbManager.insertUser("robby");
        printList(dbManager.findAllUsers());

        System.out.println("===========================");

        // Part 2
        dbManager.insertGroup("teamG");
        dbManager.insertGroup("teamH");
        printList(dbManager.findAllGroups());

        System.out.println("===========================");

    }

}

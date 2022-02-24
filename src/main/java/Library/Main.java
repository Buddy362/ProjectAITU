package Library;

import Library.conn.conn;

import java.sql.SQLException;
import java.util.Scanner;

public class Main<menu> {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        conn conn = new conn();
        conn.getC();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please choice your categories" +
                "Enter 1 for admin panel enter 2 for Student panel");

        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println(" admin");
            menu.ShowMenu();
        } else if (choice == 2) {
            System.out.println(" student ");
            menu.ShowMenuStudent();
        } else {
            System.out.println(" error ");
        }


    }
}




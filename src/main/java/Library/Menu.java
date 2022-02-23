package Library;

import Library.conn.conn;
import Library.object.Book;
import Library.object.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Option_admin option= new Option_admin();
    public void ShowMenu() throws SQLException {
        int choice = -1 ;
        Scanner scanner = new Scanner(System.in);
        while (choice !=0 ) {

            System.out.println("Welcome to the AITU Library");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Print students information");
            System.out.println("4. remove student ");
            System.out.println("0. Exit");
            choice = scanner.nextInt();


            switch (choice){
                case 1 :
                    System.out.println(" write title");
                    String title = scanner.next();
                    System.out.println(" author ");
                    String author = scanner.next();
                    System.out.println(" isbn ");
                    String isnb = scanner.next();
                    System.out.println(" year ");
                    int year = scanner.nextInt();
                    System.out.println(" quantity ");
                    int quantity = scanner.nextInt();
                    Book book = new Book(title , author , isnb , year , quantity);
                   option.Add_Book(book);

                    break;
                case 2 :
                    option.remove_book();
                case 3 :
                    option.printInfoStudent();
                case 4 :
                    option.removeStudent();
                case 5 :
                    ///
                case 6:
                    ///
                case 7 :
                    ///
                case 8 :
                    ///
                case 0:
                    ///

            }
        }
    }


    public void ShowMenuStudent() throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        int choice = -1 ;

        Connection connection ;
        conn conn = new conn();
        Scanner scanner = new Scanner(System.in);
        while (choice !=0 ) {

            System.out.println("Welcome to the AITU Library");
            System.out.println("1. Print book");
            System.out.println("2. get book");
            System.out.println("3. return book ");
            System.out.println("0. Exit");
            choice = scanner.nextInt();


            switch (choice){
                case 1 :
                    option.print_book();
                    break;
                case 2 :
                    System.out.println(" enter id");
                    int id = scanner.nextInt();
                    System.out.println(" enter name ");
                    String name = scanner.next();
                    System.out.println(" enter surname");
                    String surname = scanner.next();
                    System.out.println(" enter group ");
                    String group = scanner.next();
                    System.out.println(" enter book id ");
                    int b_id = scanner.nextInt();
                    System.out.println(" enter book name");
                    String book_name = scanner.next();
                    Student student = new Student(id , name , surname , group , b_id , book_name);
                    option.getBook(student);
                    connection = conn.getC();
                    String sql = "delete from book_libr where id = ' "  +b_id + "'";
                   PreparedStatement pr = connection.prepareStatement(sql);

                   pr.executeUpdate();

                    break;
                case 3 :
                    option.returnBook();
                    System.out.println(" write title");
                    String title = scanner.next();
                    System.out.println(" author ");
                    String author = scanner.next();
                    System.out.println(" isbn ");
                    String isnb = scanner.next();
                    System.out.println(" year ");
                    int year = scanner.nextInt();
                    System.out.println(" quantity ");
                    int quantity = scanner.nextInt();
                    Book book = new Book(title , author , isnb , year , quantity);
                    option.Add_Book(book);
                    break;

                case 0:


            }
        }
    }


}

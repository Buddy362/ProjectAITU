package Library.object;

import Library.conn.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);


    public void addBook(Book book) throws SQLException {
        try {
            conn conn_1 = new conn();
            conn_1.getC();
            Connection connection1 = null;
            PreparedStatement preparedStatement = null;

            connection1 = conn_1.getC();
            preparedStatement = connection1.prepareStatement("INSERT INTO libr3 (title , Author , Isbn , year , quantity , id) values (? , ? , ? , ? , ?)");
            preparedStatement.setString(1 , book.getTitle());
            preparedStatement.setString(2 , book.getAuthor());
            preparedStatement.setString(3,book.getIsbn());
            preparedStatement.setInt(4 , book.getQuantity());
            preparedStatement.setInt(5 , book.getYear());
            preparedStatement.executeUpdate();
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }
}

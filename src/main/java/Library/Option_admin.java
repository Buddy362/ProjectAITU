package Library;

import Library.conn.conn;
import Library.object.Book;
import Library.object.Student;

import java.sql.*;
import java.util.Scanner;


public class Option_admin {
    conn conn = new conn();
    Connection connection = null;
    Statement statement = null;
    Scanner scanner = new Scanner(System.in);
    public void Add_Book(Book book) throws SQLException {

        connection = conn.getC();
        String SQL_ADD_BOOK = " INSERT INTO book_libr (title , author , isbn , year , quantity) values (? , ? ,  ? , ? , ?)";
        PreparedStatement pr = connection.prepareStatement(SQL_ADD_BOOK);

    pr.setString(1 , book.getTitle());
    pr.setString(2 , book.getAuthor());
    pr.setString(3 , book.getIsbn());
    pr.setInt(4 , book.getYear());
    pr.setInt(5 , book.getQuantity());
    pr.executeUpdate();

//        ResultSet resultSet = pr.executeQuery();
//        if(resultSet.next()){
//            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + resultSet.getString(3) + " " + resultSet.getString(4));
//        }
//        else {
//            System.err.println(" wrong ");
//        }
    }

    public void remove_book() throws SQLException {
        connection = conn.getC();
        System.out.println(" enter id");
        int id = scanner.nextInt();
        String SQL_REMOVE_BOOK = "delete from book_libr where id = ' "  +id + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_REMOVE_BOOK);
        preparedStatement.executeUpdate();
    }

    public void printInfoStudent() throws SQLException {
        connection = conn.getC();
        Statement statement = conn.getC().createStatement();
        String name = scanner.nextLine();
        String SQL_PRINT_INFO = "select * from student_libr2 where name = '" + name + "'"  ;
        ResultSet resultSet = statement.executeQuery(SQL_PRINT_INFO);
        if (resultSet.next()){
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
        }
        if(!resultSet.next()){
            System.out.println(" ---- ");
        }
    }

    public void removeStudent() throws SQLException {

        connection = conn.getC();
        int id = scanner.nextInt();
        String SQL_REMOVE_STUDENT = "delete from student_libr2 where id = ' "+ id +" '";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_REMOVE_STUDENT);
        preparedStatement.executeUpdate();
        System.out.println(" this student was removed ");
    }

//    public void getBook(Book B , Student S) throws SQLException {
//        connection = conn.getC();
//        Statement statement = conn.getC().createStatement();
//        String name = scanner.nextLine();
//        String SQL_GET_BOOK = " insert into student_book (id , name , surname , group1 , id_book , title , author , isbn , year , quantity) values (? , ? , ? ,  ?  , ? , ?  , ? , ?  , ?  , ? )";
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BOOK);
//        int id = scanner.nextInt();
//        preparedStatement.setInt(1 , S.getId()); preparedStatement.setString(2 , name);
//        preparedStatement.setString(3 , S.getSurname()); preparedStatement.setString(4 , S.getGroup());
//        preparedStatement.setInt(5 , B.getId()); preparedStatement.setString(6 , B.getTitle()) ; preparedStatement.setString(7 , B.getAuthor());
//        preparedStatement.setString(8 , B.getIsbn()); preparedStatement.setInt(9 , B.getYear()); preparedStatement.setInt(10 , B.getQuantity());
//        preparedStatement.executeUpdate();
//    }

    public void getBook(Student s) throws SQLException {
        connection = conn.getC();
        Statement statement = conn.getC().createStatement();
        String SQL_GET_BOOK = " insert into student_libr2 (id , name , surname , group1 , id_book , book_name) values (? , ? ,? , ? , ? ,  ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BOOK);
        preparedStatement.setInt(1 ,s.getId());
        preparedStatement.setString(2 , s.getName());
        preparedStatement.setString(3 , s.getSurname());
        preparedStatement.setString(4 , s.getGroup());
        preparedStatement.setInt(5 , s.getB_id());

        preparedStatement.setString(6 , s .getB_name());
        preparedStatement.executeUpdate();
    }
    public void recognBook() throws SQLException {
        connection = conn.getC();
        Statement statement = conn.getC().createStatement();
        int id = scanner.nextInt();
        String sql = " insert into student_book where id = ' " + id + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeQuery();

    }
    public void returnBook() throws SQLException {
        connection =conn.getC();
        Statement statement = conn.getC().createStatement();
        System.out.println("enter book id ");
        int id = scanner.nextInt();
        String SQL_REMOVE_STUDENT = "delete from student_libr2 where id = ' "+ id +" '";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_REMOVE_STUDENT);
        preparedStatement.executeUpdate();



    }
    public void print_book() throws SQLException {
        connection = conn.getC();
        statement = conn.getC().createStatement();
        String SQL = "select * from book_libr";
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6));
        }

    }


}

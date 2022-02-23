package Library.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {

    public Connection getC() {
        try{
            String URL = "jdbc:postgresql://localhost:5432/postgres";
            Connection connection = DriverManager.getConnection(URL,"postgres","root");
            return connection;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}



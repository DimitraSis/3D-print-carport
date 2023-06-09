import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreeDPrintDB {

        private Connection connection;
        private final String USER;
        private final String PASSWORD;
        private final String URL;

        public ThreeDPrintDB(String user, String password, String url) {
            USER = user;
            PASSWORD = password;
            URL = url;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {

                e.printStackTrace();
                System.out.println("Fejl ved instantiering af Driver klasse");
            }
        }

        public Connection connect(){
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException throwables) {

                throwables.printStackTrace();
                System.out.println("Fejl under etablering af forbindelse til database");
            }
            return connection;
        }
    }

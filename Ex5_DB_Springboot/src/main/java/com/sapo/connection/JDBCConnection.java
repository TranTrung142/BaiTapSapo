package com.sapo.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String dbName = "ex3_mysql";
        String userName = "root";
        String password = "trantrung142";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException,
            ClassNotFoundException {
        // Khai báo class Driver cho DB MySQL
        // Việc này cần thiết với Java 5
        // Java6 trở lên tự động tìm kiếm Driver thích hợp.
        // Nếu bạn dùng Java > 5, thì ko cần dòng này cũng được.
        Class.forName("com.mysql.jdbc.Driver");

        // Cấu trúc URL Connection dành cho MySQL
        // Ví dụ: jdbc:mysql://localhost:3306/ex3_mysql
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = getMySQLConnection();
        if(connection != null){
            System.out.println("thanh cong");
        }else {
            System.out.println("that bai");
        }
    }
}

package com.sapo.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Lấy ra đối tượng Connection kết nối vào DB.
        Connection connection = ConnectionUtils.getMyConnection() ;
        // Tạo đối tượng Statement.
        Statement statement = connection.createStatement();
        //cau lenh truy van sql
        String sql = "SELECT * FROM ex3_mysql.product;";
        //Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);
        //duyet ket qua tra ve
        while (rs.next()){
            int idProduct = rs.getInt("IDProduct");
            String name = rs.getString("Name");
            long price = rs.getLong("Price");
            int idCategory = rs.getInt("IDCategory");
            System.out.println("-----");
            System.out.println("IdProduct: "+idProduct);
            System.out.println("Name product: "+name);
            System.out.println("Price product: "+price);
            System.out.println("IdCategory: "+idCategory);
        }
        
        connection.close();
    }
}

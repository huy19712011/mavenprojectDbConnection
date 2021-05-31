/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author huynq
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello Connection Pool");
        
        try {
            
            Connection connection = DatabaseConnectionPoolManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                System.out.println(resultSet.getString("email"));
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}

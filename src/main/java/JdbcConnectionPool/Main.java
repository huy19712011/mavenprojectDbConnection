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
 * works properly!!! 20-7-2021
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello Connection Pool");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = DatabaseConnectionPoolManager.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM student";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("email"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException ignore) {
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException ignore) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException ignore) {
            }

        }
    }

}

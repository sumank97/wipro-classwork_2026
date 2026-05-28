package automationpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseReadDemo
{
    public static void main(String[] args) throws Exception
    {
        Connection con =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/seleniumdb",
                        "root",
                        "K9r54tbu@12345");

        Statement stmt =
                con.createStatement();

        ResultSet rs =
                stmt.executeQuery("select * from login");

        while(rs.next())
        {
            System.out.println("Username : "
                    + rs.getString("username"));

            System.out.println("Password : "
                    + rs.getString("password"));
        }

        con.close();
    }
}
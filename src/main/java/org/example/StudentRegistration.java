package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class StudentRegistration
{
    public static void main( String[] args )
    {
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/student";
        final String username = "root";
        System.out.println( "Hello World!" );

        Connection connection = null;
        PreparedStatement statement = null;


        int ok;

        String sql = "INSERT INTO studentDetails VALUES(?, ?, ?, ?)";

        try{
            Object password;
            connection = DriverManager.getConnection(DATABASE_URL,
                    username,null);

            statement = connection.prepareStatement(sql);
            statement.setInt(1, 21930380);
            statement.setString(2, "Sipho");
            statement.setString(3, "Manisi");
            statement.setString(4, "21930380@mycput.ac.za");


            ok = statement.executeUpdate();

            if (ok > 0){
                System.out.println("student Succesfully added!");
                System.exit(0);
            }
            else{
                System.out.println("Error adding student!");
            }
        }


        catch(SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error:" + sqlException.getMessage());
        }

        finally{
            try{
                if(statement != null)
                    statement.close();
            }

            catch(Exception exp){
                JOptionPane.showMessageDialog(null, exp.getMessage(), "Warning" , JOptionPane.ERROR_MESSAGE );
            }
            try{
                if(connection != null)
                    connection.close();
            }

            catch(Exception exp){
                JOptionPane.showMessageDialog(null, exp.getMessage(), "Warning" , JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}

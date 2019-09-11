// Course CSC 335
// Student: Michael Tocco
// Professor: Sean Harrington
//
package tictactoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseHandler {

    Connection connect = null;
    private static databaseHandler handler = null;

    private databaseHandler() {
        createConnection();
    }

    private void createConnection() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/tictactoe?serverTimezone=UTC&"
                    + "user=root&password=oatmeal21"
                    + "&useSSL=false&allowPublicKeyRetrieval=true");
        } catch (SQLException e) {
            System.out.println("Connection Exception: " + e.getMessage());
        }
    }

    public static databaseHandler getInst() {
        if (handler == null) {
            handler = new databaseHandler();
        }
        return handler;
    }

    public boolean insertUser(String firstName, String lastName, String email, String password) {
        PreparedStatement preparedStatement = null;

        try {
            ResultSet rSet;

            String countEmails = "SELECT COUNT(*) FROM USERS WHERE email = ?";
            preparedStatement = connect.prepareStatement(countEmails);
            preparedStatement.setString(1, email);
            rSet = preparedStatement.executeQuery();

            if (rSet.next()) {
                
                if (rSet.getInt(1) > 0) {
                    return false;
                }
            }
            
            String insertQuery = "INSERT INTO USERS(email, password, first_name, last_name) VALUES (?,?,?,?)";
            preparedStatement = connect.prepareStatement(insertQuery);
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            
            int result = preparedStatement.executeUpdate();
            
            return (result == 1);
            
        } catch (SQLException e) {
            System.out.println("Displayed Error: " + e.getMessage());
        }

        return false;
    }

    /**
     * @oublic
     * @param email
     * @param password
     * @return 
     * 
    */
    
    
    public int verifyCredentials(String email, String password) {

        String query = "SELECT id FROM USERS WHERE EMAIL = ? AND PASSWORD =  ?";
        
        PreparedStatement preparedStatement = null;

        try {
            
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            
            ResultSet rSet = preparedStatement.executeQuery();
            
            if (rSet.next())
            {
                return rSet.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Check Credentials Error " + e.getMessage());
                    
        }

        return -1;
    }

    public void changePassword(String email, String oldPass, String newPass){
        
        String query = "UPDATE USERS SET PASSWORD = ? WHERE (PASSWORD = ? AND EMAIL = ?)";
        PreparedStatement preparedStatement = null;
        
        try {
            
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(3, email);
            preparedStatement.setString(2, oldPass);
            preparedStatement.setString(1, newPass);
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println("Check Credentials Error " + e.getMessage());
                    
        }
        
        
    }
    
    
}

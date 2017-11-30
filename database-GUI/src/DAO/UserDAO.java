package DAO;

import Controller.Helper;
import Controller.RegisterController;
import Model.User;

import java.sql.SQLException;
import java.util.*;

public class UserDAO {

    private static final String USER_TABLE = "User";
    private static final String PASSENGER_TABLE = "Passenger";
    private static final String USER_NAME = "Username";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Password";
    private static final String IS_ADMIN = "IsAdmin";

    /*
     *  Search user by username
     */
    public static void findByUsername (String username) throws SQLException, ClassNotFoundException {
        String queryStatement = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_NAME + " = " + username;

        try {
            List<List<String>> result = DBUtil.dbExcuteQuery(queryStatement);
            // Convert result to a 1D LinkedList
            ListIterator<List<String>> iter1 = result.listIterator();
            while(iter1.hasNext()) {
                ListIterator<String> iter2 = iter1.next().listIterator();
                while(iter2.hasNext())
                    System.out.println(iter2.next());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static User findUserByUsername(String username) {
        String queryStatement = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_NAME + " = '" + username + "'";
        User user = null;
        try {
            List<List<String>> result = DBUtil.dbExcuteQuery(queryStatement);
            if (result.size() == 0) {
                System.out.println("Not found");
            } else {
                List<String> userInfo = result.get(0);
//                System.out.println(userInfo.size());
                user = new User(userInfo.get(0),userInfo.get(1),Boolean.parseBoolean(userInfo.get(2)));
            }
        }
        catch (Exception e) {
            Helper.showAlert("Error", e.getMessage());
            return user;
        }

        return user;
    }

    public static boolean hasUser(String userName) {
        String queryStatement = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_NAME + " = '" + userName + "'";
        try {
            List<List<String>> result = DBUtil.dbExcuteQuery(queryStatement);
            if (result.size() == 0) {
                return false;
            } else {
                List<String> userInfo = result.get(0);
                for (String info : userInfo) {
                    System.out.println(info);
                }
                return true;
            }
        }
        catch (Exception e) {
            Helper.showAlert("Error", e.getMessage());
        }
        return false;
    }

    /*
     *  Insert a new user /NEW
     */
    public static boolean insertUser(User newUser) throws ClassNotFoundException, SQLException{
        String insertUserStatement = "INSERT INTO " + USER_TABLE + "(" +  USER_NAME + ", " +
                PASSWORD + ", " + IS_ADMIN +
                ") VALUES ('" + newUser.getUserName() + "', '" 
                + newUser.getPassword() + "', '" + newUser.isAdmin() +  "')";
        
        System.out.println(insertUserStatement);
        int updatedUserRows = 0;
        updatedUserRows = DBUtil.dbExecuteUpdate(insertUserStatement);
        int updatedPassengerRows = 0;
        
       if (!newUser.isAdmin()){
           String insertPassengerStatement = "INSERT INTO " + PASSENGER_TABLE + "(" +  USER_NAME + ", " +
                   EMAIL+") VALUES ('" + newUser.getUserName() + "', '" 
                   + newUser.getEmail() + "')";
           updatedPassengerRows = DBUtil.dbExecuteUpdate(insertPassengerStatement);
       }

        if (updatedUserRows != 0 || updatedPassengerRows != 0)
            return true;
        else
            return false;
    }

    public static boolean deleteUser(User user){
        //
        return false;
    }
}

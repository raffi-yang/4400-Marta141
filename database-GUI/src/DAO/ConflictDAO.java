package DAO;

import Controller.Helper;
import Model.Conflict;
import Model.User;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ConflictDAO {

    private static final String CONFLICT_TABLE = "Conflict";
    private static final String USER_NAME = "Username";
    private static final String CARD_NUM = "BreezecardNum";
    private static final String DATE_TIME = "DateTime";


    /*
     *  Insert a new card Conflict
     */
    public static boolean insertNewConflict(Conflict conflict) throws SQLException, ClassNotFoundException{
        String insertStatement = "INSERT INTO " + CONFLICT_TABLE + "( " +  USER_NAME + ", " + CARD_NUM + ", " +
        		DATE_TIME + ") VALUES ('" + conflict.getUserName() + "', '" + conflict.getCardNum() + "', '" +
                conflict.getDateTime() + "')";
        int updatedRows = 0;

        updatedRows = DBUtil.dbExecuteUpdate(insertStatement);

        if (updatedRows != 0)
            return true;
        else
            return false;
    }
    
    /*
     *  Retrieve all card Conflicts
     */
    public static List<List<String>> findAllConflict() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM " + CONFLICT_TABLE + " ORDER BY " + CARD_NUM;
        List<List<String>> result = new LinkedList<>();
        try {
            result = DBUtil.dbExcuteQuery(query);
        } catch (SQLException e){
            System.out.println(e);
        }
        return result;
    }
}
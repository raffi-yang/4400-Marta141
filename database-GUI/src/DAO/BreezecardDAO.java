package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BreezecardDAO {

    private static final String CARD_TABLE = "Breezecard";
    private static final String CARDNUM = "BreezecardNum";
    private static final String CARDVALUE = "Value";
    private static final String CARDOWNER = "BelongsTo";

    /*
     *  Retrieve all Breezecard order by username
     */
    public static List<List<String>> findAllBreezecardOwned(String username) throws SQLException, ClassNotFoundException {
        String query= "SELECT * FROM " + CARD_TABLE + " WHERE " + CARDOWNER + " = '" + username + "'";
        List<List<String>> result = new LinkedList<>();
        try {
            result = DBUtil.dbExcuteQuery(query);
        } catch (SQLException e){
            System.out.println(e);
        }
        return result;
    }

    /*
     *  Retrieve all breezecard
     */
    public static List<List<String>> findAllBreezecard() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM " + CARD_TABLE + " ORDER BY " + CARDNUM;
        List<List<String>> result = new LinkedList<>();
        try {
            result = DBUtil.dbExcuteQuery(query);
        } catch (SQLException e){
            System.out.println(e);
        }
        return result;
    }
}

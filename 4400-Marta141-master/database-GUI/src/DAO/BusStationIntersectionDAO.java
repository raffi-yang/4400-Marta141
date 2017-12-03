package DAO;

import Controller.Helper;
import Model.BusStationIntersection;
import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BusStationIntersectionDAO {

    private static final String TABLE = "BusStationIntersection";
    private static final String STOP_ID = "StopID";
    private static final String INTERSECTION = "Intersection";

    /*
     *  Insert new entry
     */
    public static boolean insertIntersection(BusStationIntersection intersection) throws SQLException, ClassNotFoundException{
        String insertStatement = "INSERT INTO " + TABLE + "( " +  STOP_ID + ", " + INTERSECTION + ") "
        		+ "VALUES ('" + intersection.getIntersection() + "', '" + intersection.getStopId() +  "')";
        int updatedRows = 0;

        updatedRows = DBUtil.dbExecuteUpdate(insertStatement);

        if (updatedRows != 0)
            return true;
        else
            return false;
    }

    public static boolean updateIntersection(String stopID, String intersectionName) throws SQLException, ClassNotFoundException{
        String update = "UPDATE " + TABLE + " SET " +  INTERSECTION + "= " + intersectionName 
        		+ " WHERE " + STOP_ID + " = " + stopID;
        System.out.println(update);
        Statement stmt = null;
        int updatedRow = 0;

        DBUtil.dbConnection();
        stmt = DBUtil.con.createStatement();
        updatedRow = stmt.executeUpdate(update);

        // Store result in a list
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) {
            } // ignore
            stmt = null;
        }
        DBUtil.dbDisconnect();

        if (updatedRow > 0) {
            return true;
        } else {
            return false;
        }
    }
}

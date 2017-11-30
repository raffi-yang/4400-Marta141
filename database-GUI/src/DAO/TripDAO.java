package DAO;

import Controller.Helper;
import Model.Trip;
import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TripDAO {

    private static final String TABLE = "Trip";
    private static final String TRIP_FARE = "Tripfare";
    private static final String START_TIME = "StartTime";
    private static final String CARD_NUM = "BreezecardNum";
    private static final String START_STATION = "StartsAt";
    private static final String END_STATION = "EndsAt";

    /*
     *  Insert a new Trip
     */
    public static boolean insertNewTrip(Trip trip) throws SQLException, ClassNotFoundException{
        String insertStatement = "INSERT INTO " + TABLE + "( " +  TRIP_FARE + ", " + START_TIME + ", " +
                CARD_NUM + ", " + START_STATION + ", " + END_STATION + ") VALUES ('" +
        		trip.getTripFare() + "', '" + trip.getTripTime() + "', '" +
                trip.getCardNum() + "', '" + trip.getTripStartStationID() +
                "', '" + trip.getTripEndStationID() +  "')";
        int updatedRows = 0;

        updatedRows = DBUtil.dbExecuteUpdate(insertStatement);

        if (updatedRows != 0)
            return true;
        else
            return false;
    }

}

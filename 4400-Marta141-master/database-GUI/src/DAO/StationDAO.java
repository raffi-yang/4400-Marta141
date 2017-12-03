package DAO;

import Controller.Helper;
import Controller.RegisterController;
import Model.Station;

import java.sql.SQLException;
import java.util.*;

public class StationDAO {

    private static final String STATION_TABLE = "Station";
    private static final String STOP_ID = "StopID";
    private static final String STOP_NAME = "Name";
    private static final String FARE = "EnterFare";
    private static final String CLOSED_STATUS = "ClosedStatus";
    private static final String IS_TRAIN = "IsTrain";

    /*
     *  Search Station by stationID
     */
    public static Station findUserByUsername(String stationID) {
        String queryStatement = "SELECT * FROM " + STATION_TABLE + " WHERE " + STOP_ID + " = '" + stationID + "'";
        Station user = null;
        try {
            List<List<String>> result = DBUtil.dbExcuteQuery(queryStatement);
            if (result.size() == 0) {
                System.out.println("Not found");
            } else {
                List<String> stationInfo = result.get(0);
                user = new Station(stationInfo.get(0),stationInfo.get(1),
                		Double.parseDouble(stationInfo.get(2)),
                		Boolean.parseBoolean(stationInfo.get(3)),
                		Boolean.parseBoolean(stationInfo.get(4))
                		);
            }
        }
        catch (Exception e) {
            Helper.showAlert("Error", e.getMessage());
            return user;
        }

        return user;
    }

    /*
     *  Insert a new Station
     */
    public static boolean insertStation(Station newStation) throws ClassNotFoundException, SQLException{
    	//
    	return false;
    }

    public static boolean deleteStation(Station station){
        //
        return false;
    }
}

package com.labus.mycinema.dao;

import com.labus.mycinema.entity.Movies;
import com.labus.mycinema.entity.Timetable;
import com.labus.mycinema.entity.User;
import com.labus.mycinema.entity.UserRole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimetableDao extends EntityDao {
    private final static String SELECT_ALL = "SELECT `SeansID`, `Time`, `Movie_id`, `Price`, `Visible` FROM cinemadb.timetable";

    public List<Timetable> getTimeTable(){
        takeConnection();
        List<Timetable> timetables = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Timetable timetable = retrieveEntity(resultSet);
                timetables.add(timetable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            returnConnection(connection);
        }
        timetables.sort((o1,o2)->o1.getTime().compareTo(o2.getTime()));
        return timetables;
    }

    private Timetable retrieveEntity(ResultSet resultSet) {
        Timetable timetable = new Timetable();
        try{
            timetable.setId(resultSet.getInt("SeansId"));
            timetable.setTime(resultSet.getTimestamp("Time"));
            timetable.setMovieId(resultSet.getInt("Movie_id"));
            timetable.setPrice(resultSet.getInt("Price"));
            timetable.setVisible(resultSet.getShort("Visible"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timetable;
    }
}

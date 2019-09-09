package com.labus.mycinema.action;

import com.labus.mycinema.action.exception.ActionException;
import com.labus.mycinema.dao.MoviesDao;
import com.labus.mycinema.dao.TimetableDao;
import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.entity.Timetable;
import com.labus.mycinema.entity.User;
import com.labus.mycinema.entity.UserRole;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DefaultAction implements Action{

    private final static Logger logger = Logger.getLogger(DefaultAction.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ActionException {
/*
        req.getSession().setAttribute("user",new User(0,"Labus","1234", UserRole.ADMIN,"Vitaliy","Labusyuk","+380630461182","labusyuk@gmail.com"));
*/
        List<Timetable> timetables = null;
        try {
            timetables = new TimetableDao().getTimeTable();
            timetables.sort((x,y)->x.getTime().compareTo(y.getTime()));
            req.setAttribute("timetable",timetables);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getCause().getMessage());
        }
/*        for(Timetable timetable: timetables){
            System.out.println(new MoviesDao().getById(timetable.getMovieId()).getName()+" "+timetable.getTime().toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        }*/
        return "movies-list";
    }

}

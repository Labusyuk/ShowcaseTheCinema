package com.labus.mycinema.controller;

import com.labus.mycinema.action.Action;
import com.labus.mycinema.action.ActionFactory;
import com.labus.mycinema.action.exception.ActionException;
import com.labus.mycinema.dao.MoviesDao;
import com.labus.mycinema.dao.TimetableDao;
import com.labus.mycinema.entity.Timetable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Time;

public class MainController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcessRequest(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcessRequest(request,response);
    }
    private void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Action command = ActionFactory.defineAction(request);
        String result;
        try {
            result = command.execute(request, response);
        } catch (ActionException e) {
            throw new ServletException();
        }
        System.out.println(result+" | message | "+request.getSession().getAttribute("MessageLogin"));
        if (request.getMethod().equals("POST")) {
            response.sendRedirect(result);
        } else if (request.getMethod().equals("GET")){
            request.getRequestDispatcher("/views/" + result + ".jsp").forward(request,response);
        }
    }
}

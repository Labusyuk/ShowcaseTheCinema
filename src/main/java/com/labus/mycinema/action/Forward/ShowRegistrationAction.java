package com.labus.mycinema.action.Forward;

import com.labus.mycinema.action.Action;
import com.labus.mycinema.action.exception.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowRegistrationAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ActionException {
        return "reg";
    }
}

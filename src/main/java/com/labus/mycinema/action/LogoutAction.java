package com.labus.mycinema.action;

import com.labus.mycinema.action.exception.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ActionException {
        req.getSession().removeAttribute("user");
        return "default";
    }
}

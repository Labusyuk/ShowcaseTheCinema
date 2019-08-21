package com.labus.mycinema.action;

import com.labus.mycinema.action.exception.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    String execute(HttpServletRequest req, HttpServletResponse resp) throws ActionException;
}

package com.labus.mycinema.action;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory  {
    public static final Map<String, Action> actionsMap = new HashMap<>();
    static {
        actionsMap.put("/login", new LoginAction());
    }

    public static Action defineAction(HttpServletRequest req) {
        String actionPath = req.getPathInfo();
        System.out.println(actionPath);
        return actionsMap.get(actionPath);
    }

}

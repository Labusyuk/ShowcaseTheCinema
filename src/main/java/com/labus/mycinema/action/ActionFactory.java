package com.labus.mycinema.action;

import com.labus.mycinema.action.Forward.ShowAuthorizationAction;
import com.labus.mycinema.action.Forward.ShowRegistrationAction;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory  {
    public static final Map<String, Action> actionsMap = new HashMap<>();
    static {
        actionsMap.put("/index", new DefaultAction());
        actionsMap.put("/login", new ShowAuthorizationAction());
        actionsMap.put("/registration", new ShowRegistrationAction());
        actionsMap.put("/showplaces", new ShowPlacesAction());
        actionsMap.put("/addmovie", new AddMovieAction());
        actionsMap.put("/auth", new AuthAction());
        actionsMap.put("/regSignIn", new RegistrationAction());
        actionsMap.put("/logout", new LogoutAction());
    }


    public static Action defineAction(HttpServletRequest req) {
        int[][] mass = new int[5][5];
        String actionPath = req.getPathInfo();
        Action command = actionsMap.get(actionPath);
        return command!=null?command:new DefaultAction();

    }

}

package com.labus.mycinema.action;

import com.labus.mycinema.action.exception.ActionException;
import com.labus.mycinema.dao.UserDao;
import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.db.ConnectionPool;
import com.labus.mycinema.entity.User;
import com.labus.mycinema.entity.UserRole;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationAction implements Action {

    private final static Logger logger = Logger.getLogger(RegistrationAction.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ActionException {
        String login = req.getParameter("login"),
                firstName = req.getParameter("firstName"),
                secondName = req.getParameter("secondName"),
                email = req.getParameter("email"),
                phone = req.getParameter("phone"),
                password = req.getParameter("password"),
                passwordRepeat = req.getParameter("passwordRepeat");
        String regexLogin = "[a-zA-Z0-9\\._\\-]{4,15}",
                regexName = "^(?=.{1,40}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$",
                regexEmail = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$",
                regexPhone = "[+]?\\d?[- .]?(\\([0-9]\\d{2}\\)|[0-9]\\d{2})[- .]?\\d{3}[- .]?\\d{4}$",
                regexPassword = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
        String messageNameError = "Імя може містити лише символи a-z, A-Z";
        boolean registrationFailled = false;
        if(login==null || !login.matches(regexLogin)) {
            req.getSession().setAttribute("messageRegistrationLogin", "Логін може містити лише символи a-z, A-Z, 0-9, _, -, довжина від 4 до 15 символів");
            registrationFailled = true;
        }
        if(firstName==null || !firstName.matches(regexName)) {
            req.getSession().setAttribute("messageRegistrationFirstName", messageNameError);
            registrationFailled = true;
        }
        if(secondName==null || !secondName.matches(regexLogin)) {
            req.getSession().setAttribute("messageRegistrationSecondName", messageNameError);
            registrationFailled = true;
        }
        if(email==null || !email.matches(regexEmail)) {
            req.getSession().setAttribute("messageRegistrationEmail", "Некоректний Email");
            registrationFailled = true;
        }
        if(phone==null /*|| !phone.matches(regexPhone)*/) {
            req.getSession().setAttribute("messageRegistrationPhone", "Некоректний номер телефону");
            registrationFailled = true;
        }
        if(password==null || !password.matches(regexPassword)) {
            req.getSession().setAttribute("messageRegistrationPassword", "Довжина паролю повина бути в 8 до 40 символів, хочаб одна цифра, мала, велика і хочаб один спец. символ (@ # $ % ! .)");
            registrationFailled = true;
        }
            else if(!password.equals(passwordRepeat)) {
            req.getSession().setAttribute("messageRegistrationPassword", "Паролі не співпадають");
            registrationFailled = true;
        }
            if(registrationFailled) return "registration";
        User user = new User();
        user.setLogin(login);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setRole(UserRole.USER);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        try {
            if(new UserDao().isRegistered(user)) {
                req.getSession().setAttribute("messageRegistration", "Логін, телефон або емейл уже використовується");
                return "registration";
            }
            new UserDao().create(user);
            req.getSession().setAttribute("user",user);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getCause().getMessage());
        }
        return "index";
    }
}

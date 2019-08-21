package com.labus.mycinema.action;

import com.labus.mycinema.action.exception.ActionException;
import com.labus.mycinema.dao.UserDao;
import com.labus.mycinema.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ActionException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(login == null || password == null) {
            return "login";
        }
        User user = new UserDao().getByLogAndPass(login, md5Custom(password));
        if (user == null ) {
            req.getSession().setAttribute("message", "Неправильный логин или пароль");
            return "default";
        }
        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("role", user.getRole());
        req.getSession().removeAttribute("message");
        return "user";
    }
    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // тут можно обработать ошибку
            // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}

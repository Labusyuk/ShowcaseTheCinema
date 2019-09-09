package com.labus.mycinema.action;

import com.labus.mycinema.action.exception.ActionException;
import com.labus.mycinema.dao.UserDao;
import com.labus.mycinema.dao.exception.DaoException;
import com.labus.mycinema.entity.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthAction implements Action {

    private final static Logger logger = Logger.getLogger(AuthAction.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ActionException {
        String login = req.getParameter("name");
        String password = req.getParameter("password");
        User user;
        try {
            if(login == null || password == null || (user = new UserDao().getByLogAndPass(login, md5Custom(password))) == null) {
                req.getSession().setAttribute("MessageLogin", "Неправильний логін або пароль");
                return "login";
            }
        req.getSession().setAttribute("user", user);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getCause().getMessage());
        }
        return "index";
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
            logger.log(Level.ERROR, e.getMessage());
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}

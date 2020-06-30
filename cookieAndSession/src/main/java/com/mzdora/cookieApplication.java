package com.mzdora;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class cookieApplication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Cookie[] cookie = req.getCookies();
        if( cookie!=null ){
            out.print("Your Last Visit time is:");
            for(int i=0;i<cookie.length;i++){
                if( cookie[i].getName().equals("LocalTime") ){
                    long lastLoginTime = Long.parseLong(cookie[i].getValue());
                    Date date = new Date(lastLoginTime);
                    out.print(date.toLocaleString());
                }
            }
        }else{
            out.print("This is your first time visit our Website.");
        }

        Cookie c = new Cookie("LocalTime",System.currentTimeMillis()+"");
        c.setMaxAge(24*60*60);
        resp.addCookie(c);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

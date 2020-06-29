package com.mzdora;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 发送Mzdora给context
 * 然后GetServlet的context用getAttribute接收
 */

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloWorld!");
        String name = "Mzdora";
        ServletContext context = this.getServletContext();
        context.setAttribute("name",name);

    }
}

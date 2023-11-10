package ru.kpfu.itis.servlets;

import ru.kpfu.itis.dao.UserDaoImpl;
import ru.kpfu.itis.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null){
            req.getRequestDispatcher("login.ftl").forward(req,resp);
        } else {
            User user = userDao.get((Integer) session.getAttribute("userId"));
            req.setAttribute("name",user.getName());
            req.setAttribute("email",user.getEmail());
            req.getRequestDispatcher("main.ftl").forward(req,resp);
        }*/
        req.getRequestDispatcher("login.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userDao.get(email);

        HttpSession session = req.getSession(false);

        if (Objects.equals(user.getPassword(), password)){
            session.setAttribute("userId",user.getUserId());
            session.setAttribute("email",email);
            resp.sendRedirect("/main");
        } else {
            resp.sendRedirect("/home");
        }
    }
}

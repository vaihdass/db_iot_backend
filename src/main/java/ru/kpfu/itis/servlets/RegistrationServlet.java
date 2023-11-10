package ru.kpfu.itis.servlets;

import ru.kpfu.itis.Utils.PasswordUtil;
import ru.kpfu.itis.dao.UserDaoImpl;
import ru.kpfu.itis.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "registration",urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserDaoImpl userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        User newUser = new User(0,name,email,null, PasswordUtil.encrypt(password),null); // допустим сделали соли

        userDao.save(newUser);

        resp.sendRedirect("/main");
    }
}
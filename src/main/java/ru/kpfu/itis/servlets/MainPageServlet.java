package ru.kpfu.itis.servlets;

import ru.kpfu.itis.dao.HubDao;
import ru.kpfu.itis.dao.HubDaoImpl;
import ru.kpfu.itis.models.Hub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HubDao hubDao = new HubDaoImpl();

        List<Hub> hubs = hubDao.getByUserId(req.getSession(false).getAttribute("userId"));

        resp.setCharacterEncoding("UTF-8");
        for (Hub hub : hubs) {
            resp.getWriter().print("<option value=\'" + hub.getHubId() + "\'>"+ hub.getName() +"</option>");
        }
    }
}

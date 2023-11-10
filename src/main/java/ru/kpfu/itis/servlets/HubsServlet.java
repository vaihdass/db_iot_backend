package ru.kpfu.itis.servlets;

import ru.kpfu.itis.dao.HubDao;
import ru.kpfu.itis.dao.HubDaoImpl;
import ru.kpfu.itis.models.Hub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/hubs")
public class HubsServlet extends HttpServlet {
    HubDao hubDao = new HubDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            List<Hub> hubs = hubDao.getByUserId((Integer) req.getSession(false).getAttribute("userId"));

            resp.setCharacterEncoding("UTF-8");
            for (Hub hub : hubs) {
                resp.getWriter().print("<option value=\'" + hub.getHubId() + "\'>" + hub.getName() + "</option>");
            }
        }
    }
}

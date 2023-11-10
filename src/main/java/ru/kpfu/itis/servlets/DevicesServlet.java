package ru.kpfu.itis.servlets;

import ru.kpfu.itis.Utils.ByteArrayPropertyInfoProcessor;
import ru.kpfu.itis.dao.HubDaoImpl;
import ru.kpfu.itis.dao.SensorLogDaoImpl;
import ru.kpfu.itis.deviceDto.SensorWithType;
import ru.kpfu.itis.models.Sensor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/device")
public class DevicesServlet extends HttpServlet {
    HubDaoImpl hubDao = new HubDaoImpl();
    SensorLogDaoImpl sensorLogDao = new SensorLogDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hubId = req.getParameter("id");
        if (hubId == null || hubId.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing 'id' parameter");
            return;
        }

        List<SensorWithType> sensors = hubDao.getSensorsByHubId(Integer.parseInt(hubId));
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.append("<div>\n");
        for (SensorWithType sensor : sensors) {
            byte[] info = sensorLogDao.get(sensor.getSensor().getSensorId()).getData();
            String sensorResult = ByteArrayPropertyInfoProcessor.getProperties(info,sensor.getType().getName());
            writer.append("<div>")
                    .append("Sensor ID: ").append(String.valueOf(sensor.getSensor().getSensorId()))
                    .append(", Name: ").append(sensor.getSensor().getName())
                    .append(", результат работы: ").append(sensorResult)
                    .append(", Type: ").append(sensor.getType().getName())
                    .append(", Description: ").append(sensor.getType().getDescription())
                    .append(", Date of Entry: ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sensor.getSensor().getDateOfEntry()))
                    .append("</div>\n");
        }
        writer.append("</div>");
    }

}

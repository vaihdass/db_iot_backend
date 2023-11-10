package ru.kpfu.itis.servlets;

import com.google.gson.Gson;
import ru.kpfu.itis.Utils.ByteArrayPropertyInfoProcessor;
import ru.kpfu.itis.dao.HubDaoImpl;
import ru.kpfu.itis.dao.SensorLogDaoImpl;
import ru.kpfu.itis.deviceDto.SensorWithType;
import ru.kpfu.itis.models.Sensor;
import ru.kpfu.itis.models.SensorInfo;
import ru.kpfu.itis.models.SensorLog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/device")
public class DevicesServlet extends HttpServlet {
    HubDaoImpl hubDao = new HubDaoImpl();
    SensorLogDaoImpl sensorLogDao = new SensorLogDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String hubId = req.getParameter("id");
        if (hubId == null || hubId.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing 'id' parameter");
            return;
        }

        List<SensorWithType> sensors = hubDao.getSensorsByHubId(Integer.parseInt(hubId));
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.append("[");
        for (SensorWithType sensor : sensors) {
            SensorLog sensorLog = sensorLogDao.getLastLog(sensor.getSensor().getSensorId());
            byte[] info = sensorLog.getData();
            info = info == null ? String.valueOf(sensorLog.getStatus()).getBytes() : info;
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sensorLogDao
                    .getLastLog(sensor.getSensor().getSensorId()).getTime());
            String sensorResult = ByteArrayPropertyInfoProcessor.getProperties(info, sensor.getType().getName());

            Gson gson = new Gson();
            String json = gson.toJson(new SensorInfo(
                    String.valueOf(sensor.getSensor().getSensorId()),
                    sensor.getSensor().getName(),
                    sensorResult,
                    sensor.getType().getName(),
                    sensor.getType().getDescription(),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sensor.getSensor().getDateOfEntry()),
                    date
            ));
            writer.append(json + ",");
        }
        writer.append("]");
    }

}

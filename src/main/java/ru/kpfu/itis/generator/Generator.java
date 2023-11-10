package ru.kpfu.itis.generator;

import ru.kpfu.itis.dao.HubDaoImpl;
import ru.kpfu.itis.dao.SensorLogDaoImpl;
import ru.kpfu.itis.deviceDto.SensorWithType;
import ru.kpfu.itis.models.SensorLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Integer hubId = Integer.parseInt(scanner.nextLine());

        HubDaoImpl hubDao = new HubDaoImpl();
        List<SensorWithType> sensors = hubDao.getSensorsByHubId(hubId);

        List<SensorLog> sensorLogs = new ArrayList<>();

        SensorLogDaoImpl sensorLogDao = new SensorLogDaoImpl();

        for (SensorWithType sensor : sensors) {
            sensorLogs.add(sensorLogDao.getLastLog(sensor.getSensor().getSensorId()));
        }


        while (true) {
            int i = 0;
            for (SensorLog sensorLog : sensorLogs) {
                update(sensorLog, sensors.get(i).getType().getTypeId());
                sensorLogDao.update(sensorLog);
                i++;
            }
            Thread.sleep(5000);
        }
    }

    public static void update(SensorLog sensorLog, Integer typeId) {
        if (typeId == 1) {
            Random random = new Random();
            int randomInt = random.nextInt(-1, 3);
            sensorLog.setStatus(randomInt);
            if (randomInt == -1) sensorLog.setMessage("Ошибка");
            if (randomInt == 0) sensorLog.setMessage("Жалюзи / шторы закртыты");
            if (randomInt == 1) sensorLog.setMessage("Жалюзи / шторы открыты");
        } else if (typeId == 2){
            Random random = new Random();
            int randomInt = random.nextInt(-1, 3);
            sensorLog.setStatus(randomInt);
            if (randomInt == -1) sensorLog.setMessage("Ошибка");
            if (randomInt == 0) sensorLog.setMessage("Движение не обнаружено");
            if (randomInt == 1) sensorLog.setMessage("Движение обнаружено");
        } else if (typeId == 3){
            List<Byte> bytes = new ArrayList<>();
            Random random = new Random();

            String color = "";
            int randomInt = random.nextInt(1, 4);
            if (randomInt == 1) color = "red";
            if (randomInt == 2) color = "green";
            if (randomInt == 3) color = "blue";

            int intensity = random.nextInt(0, 101);

            sensorLog.setData(("{'color':'"+ color + "', 'intensivity','" + intensity + "'}").getBytes());
        } else if (typeId == 4) {
            Random random = new Random();
            int randomInt = random.nextInt(-1, 3);
            sensorLog.setStatus(randomInt);
            if (randomInt == -1) sensorLog.setMessage("Ошибка");
            if (randomInt == 0) sensorLog.setMessage("Протечка обнаружена");
            if (randomInt == 1) sensorLog.setMessage("Протечка не обнаружена");
        } else if (typeId == 5) {
            Random random = new Random();
            int randomInt = random.nextInt(-1, 3);
            sensorLog.setStatus(randomInt);
            if (randomInt == -1) sensorLog.setMessage("Ошибка");
            if (randomInt == 0) sensorLog.setMessage("Дверь/окно закрыто.");
            if (randomInt == 1) sensorLog.setMessage("Дверь/окно открыто.");
        } else if (typeId == 6) {
            Random random = new Random();
            int randomInt = random.nextInt(-1, 3);
            sensorLog.setStatus(randomInt);
            if (randomInt == -1) sensorLog.setMessage("Ошибка");
            if (randomInt == 0) sensorLog.setMessage("Задымление обнаружено.");
            if (randomInt == 1) sensorLog.setMessage("Задымление не обнаружено.");
        }
    }
}

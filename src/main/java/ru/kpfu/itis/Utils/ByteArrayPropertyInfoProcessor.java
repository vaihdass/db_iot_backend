package ru.kpfu.itis.Utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.nio.charset.StandardCharsets;

public class ByteArrayPropertyInfoProcessor {
    public static String getProperties(byte[] arr, String type) {
        Gson gson = new Gson();
        switch (type) {
            case "Датчик движения":
                return arr[0] == 0? "движений не обнаружено": "обнаружено движение";
            case "Датчик протечки воды":
                return arr[0] == 0? "вода не льется": "вода льется";
            case "Датчик открытия двери/окна":
                return arr[0] == 0? "дверь закрыта": "дверь открыта";
            case "Датчик для управления жалюзи и шторами":
                return arr[0] == 0? "шторы закрыты": "шторы открыты";
            case "Датчик дыма":
                return arr[0] == 0? "задымление не обнаружено": "задымление обнаружено";
            case "Датчик для управления цветом и интенсивностью домашнего освещения":
                /*JsonObject jsonObject = gson.fromJson(new String(arr), JsonObject.class);
                String color = jsonObject.get("color").getAsString();
                String intensity = jsonObject.get("intensity").getAsString();
                return "цвет: " + color + ", интенсивность: " + intensity;*/
                return new String(arr, StandardCharsets.UTF_8);
            default: return "неизвестное состояние";
        }
    }
}

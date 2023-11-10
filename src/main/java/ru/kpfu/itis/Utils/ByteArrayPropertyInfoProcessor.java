package ru.kpfu.itis.Utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ByteArrayPropertyInfoProcessor {
    public static String getProperties(byte[] arr, String type){
        Gson gson = new Gson();
        switch (type){
            case "movement":
                return arr[0] == 0? "движений не обнаружено": "обнаружено движение";
            case "water_leak":
                return arr[0] == 0? "вода не льется": "вода льется";
            case "door_opener":
                return arr[0] == 0? "дверь закрыта": "дверь открыта";
            case "curtain_mover":
                return arr[0] == 0? "шторы закрыты": "шторы открыты";
            case "smoke_indicator":
                return arr[0] == 0? "задымление не обнаружено": "задымление обнаружено";
            case "lighting_manager":
                JsonObject jsonObject = gson.fromJson(new String(arr), JsonObject.class);
                String color = jsonObject.get("color").getAsString();
                String intensivity = jsonObject.get("intensivity").getAsString();
                return "цвет: " + color + ", интенсивность: " + intensivity;
            default: return "неизвестное состояние";
        }
    }
}

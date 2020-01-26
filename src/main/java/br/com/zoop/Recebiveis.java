package main.java.br.com.zoop;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Recebiveis {

    public Recebiveis() {

    }

    public static void main(String[] args) {
        String json = ConsultaRecebiveis.getRecebiveis();
        //String json = "[{\"name\": \"Cake\",\"cakeId\": \"0001\",\"cakeShape\": \"Heart\"}, {\"name\": \"Pie\",\"cakeId\": \"0002\",\"cakeShape\": \"Square\"}]";
        //JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        System.out.println(jsonObject.get("title"));

        ConsultaRecebiveis cr = new ConsultaRecebiveis();
        try {
            cr.consultaRecebiveis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

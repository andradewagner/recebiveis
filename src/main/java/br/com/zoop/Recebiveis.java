package main.java.br.com.zoop;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import main.java.br.com.zoop.antecipacao.Antecipacao;

public class Recebiveis {

    public Recebiveis() {

    }

    public static void main(String[] args) {
        Antecipacao antecipacao = new Antecipacao();
        //String retorno = antecipacao.criarAntecipacao();
        String retorno = antecipacao.simularAntecipacao();
        System.out.println(retorno);

        //String json = ConsultaRecebiveis.listarRecebiveis();
        String json = antecipacao.listarAntecipacao();
        
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonArray jsonArray = new JsonParser().parse(String.valueOf(jsonObject.get("items"))).getAsJsonArray();
        for (JsonElement pa : jsonArray) {
            JsonObject paymentObj = pa.getAsJsonObject();
            String id = paymentObj.get("id").getAsString();
            System.out.println(id);
        }
    }
}

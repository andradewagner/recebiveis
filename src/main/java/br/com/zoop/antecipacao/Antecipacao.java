package main.java.br.com.zoop.antecipacao;

import main.java.br.com.zoop.antecipacao.interfaces.AntecipacaoServices;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Antecipacao implements AntecipacaoServices {

    private String diaMaisUm = "";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public Antecipacao() {
        LocalDateTime ldt = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        diaMaisUm = formmat1.format(ldt);
    }


    public String criarAntecipacao() {
        StringBuffer content = new StringBuffer();
        String body = "{\"prepayment_date\": \""+diaMaisUm+"\", \"customer\": \"e101e5c63743446cbd7b1d1513aa0173\"}";
        StringEntity requestEntity = new StringEntity(body, ContentType.APPLICATION_JSON);
        HttpPost postMethod = new HttpPost("https://zoop-api-internal.staging.zoop.tech/v1/marketplaces/03f19e34108f4357a9574d999eb0308c/prepayments");
        ResponseHandler<String> handler = new BasicResponseHandler();
        postMethod.setEntity(requestEntity);
        try {
            HttpResponse response = httpClient.execute(postMethod);
            String res = handler.handleResponse(response);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String simularAntecipacao() {
        StringBuffer content = new StringBuffer();
        String body = "";
        StringEntity requestEntity = new StringEntity(body, ContentType.APPLICATION_JSON);
        Header header = new BasicHeader("X-Client-Type-Connection", "1");
        HttpPost postMethod = new HttpPost("https://zoop-api-internal.staging.zoop.tech/admin/v1/prepayments/simulate");
        postMethod.setHeader(header);
        ResponseHandler<String> handler = new BasicResponseHandler();
        postMethod.setEntity(requestEntity);
        try {
            HttpResponse response = httpClient.execute(postMethod);
            String res = handler.handleResponse(response);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String aprovarAntecipacao() {
        return null;
    }

    public String listarAntecipacao() {
        StringBuffer content = new StringBuffer();
        HttpGet getMethod = new HttpGet("https://zoop-api-internal.staging.zoop.tech/v2/marketplaces/03f19e34108f4357a9574d999eb0308c/sellers/e101e5c63743446cbd7b1d1513aa0173/prepayments");
        ResponseHandler<String> handler = new BasicResponseHandler();
        try {
            HttpResponse response = httpClient.execute(getMethod);
            String res = handler.handleResponse(response);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

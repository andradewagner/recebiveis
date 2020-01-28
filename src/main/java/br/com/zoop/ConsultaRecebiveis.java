package main.java.br.com.zoop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaRecebiveis {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public ConsultaRecebiveis() {

    }

    public static String listarRecebiveis() {

        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL("https://zoop-api-internal.staging.zoop.tech/v2/marketplaces/03f19e34108f4357a9574d999eb0308c/sellers/e101e5c63743446cbd7b1d1513aa0173/prepayments");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

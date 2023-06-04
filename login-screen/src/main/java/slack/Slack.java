/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slack;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import sql.Conection;

/**
 *
 * @author faculdade
 */
public class Slack {
    
    public static final String linkChatMonitoramento(){
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        String response = con.queryForObject("select link from Slack where id = 1", String.class);
        
        return response;
    }

    private static HttpClient client = HttpClient.newHttpClient();
    private static final String url
            = linkChatMonitoramento();

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Status: %s", response.body()));
    }
    


}

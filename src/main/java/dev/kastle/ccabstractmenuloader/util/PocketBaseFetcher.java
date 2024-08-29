package dev.kastle.ccabstractmenuloader.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kastle.ccabstractmenuloader.CCAbstractMenuLoader;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@AllArgsConstructor
public class PocketBaseFetcher {
    private final CCAbstractMenuLoader plugin;
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonNode getPocketBaseJson(String endpoint) {
        try {
            URL url = null;
            
            if (endpoint == "con_booths") {
                url = new URL("https://pocketbase.coastersandcrafters.com/api/collections/con_booths/records?expand=community&fields=community,id,location,expand&perPage=1000&filter=phase%20%3D%20%27finished%27");
            } else {
                url = new URL("https://pocketbase.coastersandcrafters.com/api/collections/"+endpoint+"/records?expand=community&perPage=1000");
            }
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                JsonNode jsonNode = mapper.readTree(connection.getInputStream());
                plugin.logger().info("Successfully fetched " + endpoint + " from PocketBase");
                return jsonNode;
            } else {
                plugin.logger().error("Failed to get response from " + endpoint + " with response code " + responseCode);
            }
        } catch (MalformedURLException e) {
            plugin.logger().error("Malformed URL: " + endpoint, e);
        } catch (IOException e) {
            plugin.logger().error("Failed to open connection to " + endpoint, e);
        }
        return null;
    }
}

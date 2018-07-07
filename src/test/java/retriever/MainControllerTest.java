package retriever;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import junit.framework.TestCase;
import main.java.retriever.MainController;

import java.io.*;
import java.net.*;

public class MainControllerTest extends TestCase {

    /* Test helper method */
    private void dummyGetRequestData() {
        String getUrl = "http://api.openweathermap.org/data/2.5/forecast?id=1642911&appid=927ac7c564019420f279e4e7a156fa32";
        try {
            URL url = new URL(getUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            try {
                connection.setRequestMethod("GET");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                try {
                    int responseCode = connection.getResponseCode();
                    if(responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        try {
                            in.close();
                            // Print to file
                            PrintWriter pw = new PrintWriter("src/resource/testdata/city_weather_data.json");
                            pw.write(response.toString());
                            pw.flush();
                            pw.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("GET Request Doesn't Worked");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParseWeatherData() {
        MainController controller = new MainController();
        dummyGetRequestData();

        JSONParser parser = new JSONParser();
        JSONObject data = new JSONObject();
        try {
            Object obj = parser.parse(new FileReader("./src/resource/testdata/city_weather_data.json"));
            data = (JSONObject) obj;
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file!");
        } catch (ParseException e) {
            System.out.println("Failed");
        } catch (IOException e) {
            e.printStackTrace();
        }

        controller.getWeatherData("1642911");
        assertEquals(data, controller.parseWeatherData());
    }

}

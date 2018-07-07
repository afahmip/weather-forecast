package main.java.retriever;

import java.io.*;
import java.net.*;

public class WeatherRetriever {

  private final String USER_AGENT = "Mozilla/5.0";
  private final String APP_ID = "927ac7c564019420f279e4e7a156fa32";
  private final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?id=";

  private String cityId;
  private String getUrl;

  public WeatherRetriever() {}

  public void initId(String cityId) {
    this.cityId = cityId;
    this.getUrl = BASE_URL + this.cityId + "&appid=" + APP_ID;
  }

  public String getCityId() { return this.cityId; }

  public String getGetUrl() { return this.getUrl; }

  public void sendGET() throws IOException {
    // DEBUG
    System.out.println(this.getUrl);

    URL url = new URL(this.getUrl);
    HttpURLConnection connection = (HttpURLConnection)url.openConnection();

    connection.setRequestMethod("GET");
    connection.setRequestProperty("User-Agent", USER_AGENT);
    int responseCode = connection.getResponseCode();
    System.out.println("GET Response Code = " + responseCode);

    if(responseCode == HttpURLConnection.HTTP_OK) {
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();
      while((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      // Print to file
      PrintWriter pw = new PrintWriter("src/resource/json/result.json");
      pw.write(response.toString());
      pw.flush();
      pw.close();
    } else {
      System.out.println("GET Request Doesn't Worked");
    }
  }
}

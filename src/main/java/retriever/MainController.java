package retriever;

import main.java.retriever.WeatherRetriever;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainController {

  private WeatherRetriever retriever;

  public MainController() {
    this.retriever = new WeatherRetriever();
  }

  public void getWeatherData(String cityId) {
    this.retriever.initId(cityId);
    try {
      this.retriever.sendGET();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public JSONObject parseWeatherData() {
    JSONParser parser = new JSONParser();
    JSONObject weatherData = new JSONObject();
    System.out.println("Parse data...");

    try {
      weatherData = (JSONObject) parser.parse(new FileReader("./src/resource/result.json"));
    } catch (FileNotFoundException e) {
      System.out.println("Cannot find file!");
    } catch (ParseException e) {
      System.out.println("Failed");
    } catch (IOException e) {
      e.printStackTrace();
    }

    return weatherData;
  }

}

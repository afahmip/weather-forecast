package retriever;

import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import main.java.retriever.DetailController;

public class DetailControllerTest extends TestCase {

  private ArrayList<JSONObject> dummyList;
  private JSONObject dummyData;
  private JSONObject dummyCityIdentity;
  private DetailController controller;

  /* Test helper methods */
  private void createDummyConstructor() {
    this.controller = new DetailController();
  }

  private void createDummyData() {
    JSONParser parser = new JSONParser();
    this.dummyData = new JSONObject();
    try {
      Object obj = parser.parse(new FileReader("./src/resource/testdata/city_single_data.json"));
      this.dummyData = (JSONObject) obj;
    } catch (FileNotFoundException e) {
      System.out.println("Cannot find file!");
    } catch (ParseException e) {
      System.out.println("Failed");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void createDummyCityIdentity() {
    JSONParser parser = new JSONParser();
    this.dummyCityIdentity = new JSONObject();
    try {
      Object obj = parser.parse(new FileReader("./src/resource/testdata/city_identity.json"));
      this.dummyCityIdentity = (JSONObject) obj;
    } catch (FileNotFoundException e) {
      System.out.println("Cannot find file!");
    } catch (ParseException e) {
      System.out.println("Failed");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /* Actual tests start here */
  @Test
  public void testGetCityName() {
    this.createDummyConstructor();
    this.createDummyCityIdentity();
    assertEquals("Jakarta", this.controller.getCityName(this.dummyCityIdentity));
  }

  @Test
  public void testGetDailyWindSpeed() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("2.96", this.controller.getDailyWindSpeed(this.dummyData));
  }

  @Test
  public void testGetDailyWindDirection() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("114.003", this.controller.getDailyWindDirection(this.dummyData));
  }

  @Test
  public void testGetDailyCloud() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("0", this.controller.getDailyCloud(this.dummyData));
  }

  @Test
  public void testGetDailyHumidity() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("94", this.controller.getDailyHumidity(this.dummyData));
  }

  @Test
  public void testGetDailyPressure() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("1023.2", this.controller.getDailyPressure(this.dummyData));
  }

  @Test
  public void testGetDailyTemp() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("26.2", this.controller.getDailyTemp(this.dummyData));
  }

  @Test
  public void testGetDailyWeatherMain() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("Clear", this.controller.getDailyWeatherMain(this.dummyData));
  }

  @Test
  public void testGetDailyWeatherDetail() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("Clear sky", this.controller.getDailyWeatherDetail(this.dummyData));
  }

  @Test
  public void testGetDailyDaySimplified() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("Thu", this.controller.getDailyDaySimplified(this.dummyData));
  }

  @Test
  public void testGetDailyDayFull() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("Thursday", this.controller.getDailyDayFull(this.dummyData));
  }

  @Test
  public void testGetDailyMonth() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("July", this.controller.getDailyMonth(this.dummyData));
  }

  @Test
  public void testGetDailyYear() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("2018", this.controller.getDailyYear(this.dummyData));
  }

  @Test
  public void testGetDailyDate() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("5", this.controller.getDailyDate(this.dummyData));
  }

  @Test
  public void testGetDateTime() {
    this.createDummyConstructor();
    this.createDummyData();
    assertEquals("2018-07-05 18:00:00", this.controller.getDateTime(this.dummyData));
  }

}

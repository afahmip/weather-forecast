package retriever;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailController {

  public String getCityName(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("city");
    return detail.get("name").toString();
  }

  public String getDailyWind(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("wind");
    return detail.get("speed").toString();
  }

  public String getDailyCloud(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("clouds");
    return detail.get("all").toString();
  }

  public String getDailyHumidity(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("main");
    return detail.get("humidity").toString();
  }

  public String getDailyPressure(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("main");
    return detail.get("pressure").toString();
  }

  public String getDailyTemp(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("main");
    Double temp = ((Double) detail.get("temp")) - 273.15;
    DecimalFormat df = new DecimalFormat("#.#");
    return String.valueOf(df.format(temp));
  }

  public String getDailyWeatherMain(JSONObject data) {
    JSONArray weather = (JSONArray) data.get("weather");
    JSONObject detail = (JSONObject) weather.get(0);
    return detail.get("main").toString();
  }

  public String getDailyWeatherDetail(JSONObject data) {
    JSONArray weather = (JSONArray) data.get("weather");
    JSONObject detail = (JSONObject) weather.get(0);
    String input = detail.get("description").toString();
    String output = input.substring(0, 1).toUpperCase() + input.substring(1);
    return output;
  }

  public String getDailyDaySimplified(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("E");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public String getDailyDayFull(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public String getDailyMonth(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public String getDailyYear(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public String getDailyDate(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("d");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public String getDateTime(JSONObject data) {
    return data.get("dt_txt").toString();
  }
}

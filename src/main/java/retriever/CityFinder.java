package main.java.retriever;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CityFinder {

  JSONParser parser;
  JSONArray citylist;

  public CityFinder() {
    this.parser = new JSONParser();
    System.out.println("Loading file...");

    try {
      Object obj = this.parser.parse(new FileReader("./src/resource/city.list.json"));
      this.citylist = (JSONArray) obj;
      System.out.println(this.citylist.size());
    } catch (FileNotFoundException e) {
      System.out.println("Cannot find file!");
    } catch (ParseException e) {
      System.out.println("Failed");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void findCityId(String cityId) {
//    for(int i = 0; i < this.citylist.size(); i++) {
//
//    }
    for(Object obj : this.citylist) {
      JSONObject tmp = (JSONObject) obj;
      String tmpId = ((Number) tmp.get("id")).toString();
      if(tmpId.equals(cityId)) {
        System.out.println(tmp.get("name"));
      }
    }
  }

}

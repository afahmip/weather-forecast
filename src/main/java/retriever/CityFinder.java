package main.java.retriever;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

  public ArrayList<JSONObject> findCityId(String name) {
    FuzzySearch fuzzy = new FuzzySearch();
    ArrayList<JSONObject> cityResult = new ArrayList<>();

    for(Object obj : this.citylist) {
      JSONObject tmp = (JSONObject) obj;
      String tmpName = tmp.get("name").toString();
      if(fuzzy.ratio(tmpName.toLowerCase(), name.toLowerCase()) >= 90) {
        // DEBUG
        // System.out.println(tmpName + " " + tmp.get("id").toString() + " " + fuzzy.ratio(tmpName.toLowerCase(), name.toLowerCase()));
        JSONObject result = new JSONObject();
        result.put("id", tmp.get("id").toString());
        result.put("name", tmpName);
        cityResult.add(result);
      }
    }
    return cityResult;
  }

}

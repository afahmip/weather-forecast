package retriever;

import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import main.java.retriever.CityFinder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CityFinderTest extends TestCase {

    /* Test helper method */
    private ArrayList<JSONObject> dummyCityIdData() {
        JSONParser parser = new JSONParser();
        ArrayList<JSONObject> array = new ArrayList<>();

        try {
            Object obj = parser.parse(new FileReader("./src/main/resource/testdata/city_id_found.json"));
            JSONArray jsonArray = (JSONArray) obj;
            array = (ArrayList<JSONObject>) jsonArray;
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file!");
        } catch (ParseException e) {
            System.out.println("Failed");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }

    /* Actual tests start here */
    @Test
    public void testFindCityId() {
        CityFinder finder = new CityFinder();
        ArrayList<JSONObject> result = finder.findCityId("Bandung");
        ArrayList<JSONObject> expected = dummyCityIdData();
        assertEquals(expected, result);
    }

}

package retriever;

import org.junit.Test;
import junit.framework.TestCase;
import main.java.retriever.WeatherRetriever;

public class WeatherRetrieverTest extends TestCase {

    /* Test helper methods */
    private WeatherRetriever createDummyConstructor() {
        WeatherRetriever retriever = new WeatherRetriever();
        retriever.initId("1650357");
        return retriever;
    }

    /* Actual tests start here */
    @Test
    public void testGetCityId() {
        WeatherRetriever retriever = createDummyConstructor();
        assertEquals("1650357", retriever.getCityId());
    }

    @Test
    public void testGetGetUrl() {
        WeatherRetriever retriever = createDummyConstructor();
        String url = "http://api.openweathermap.org/data/2.5/forecast?id=1650357&appid=927ac7c564019420f279e4e7a156fa32";
        assertEquals(url, retriever.getGetUrl());
    }

}

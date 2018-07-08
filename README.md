<h1  align="center">    
   <br>Tugas 2 Seleksi Asisten Labpro 2018<br><br>  
</h1>  
  
<h2 align="center">  
   Weather Forecast App<br><br>  
</h2>  
  
## Description  
  
This is a weather forecast app that can show weather forecast data for certain days. User can just input city location that they want, then the app will show weather forecast data on that city.  
  
## OpenWeatherMap API

In this project, I'm using [OpenWeatherMap API](https://openweathermap.org/api). **But what is an API?**    
Basically an API (Application Programming Interface) is    
    
> a set of subroutine definitions, protocols, and tools for building application software - Wikipedia    

It is part of the server that receives requests and sends responses as the way to serve customers. In other words, API is a way to communicate between software, servers, etc. Computers can retrieve remote data (using GET request), insert / update remote data (using POST request), etc.

This OpenWeatherMap API is also the same. Users can ask for certain weather data to its web server, then, the server will return certain data related to the user's needs. Basically the data sent is not in the format of natural language, rather it's in a form of [XML](https://www.w3.org/XML/), [JSON](https://www.json.org/), etc. We can ask for some data from OpenWeatherMap API, such as    
- Current Weather data    
- 5 day / 3 hour forecast    
- 16 day / daily forecast    
- Historical data    
- etc. You can see the list [here](https://openweathermap.org/api).
    
## Package Structure
**_subject to change_**

```

src
└───main
	└───java
            |   class Main
            |
            └───component
            |   |   class MainFrame
            |   |   class DetailPanel
            |   |   class SearchPanel
            |   |   class MainPanel
            |
            └───retriever
                |   class CityFinder
                |   class MainController
                |   class WeatherRetriever
                |   class DetailController
            
```

The source code is divided into two packages. One is package _component_ that stores interface component, and package _model_ that stores weather model. Package _component_ consists of class **MainFrame** (the main window), class **MainPanel** (panel that holds DetailPanel and SearchPanel as well as other interacting buttons), class **DetailPanel** (panel that show weather details), and class **SearchPanel** (panel that has search input and feature). Package _retriever_ consists of class **WeatherRetriever** that handles weather scrapping data from OpenWeatherMap API, class **DetailController** which preprocess raw JSON data and returns any attributes that are needed, class **MainController** which handles data interraction between components, and class **CityFinder** which returns city ID from given city name.

## Class / Feature Checklist

<table>
<tbody>
<tr>
<th>Package</th>
<th>Class</th>
<th>Explanation</th>
<th>Check</th>
</tr>
<tr>
<td>main.java</td>
<td>Main</td>
<td>Can run component</td>
<td>v</td>
</tr>
<tr>
<td rowspan="4">main.java.component</td>
<td>MainFrame</td>
<td>Base frame that holds all panels</td>
<td>v</td>
</tr>
<tr>
<td>DetailPanel</td>
<td>Showing daily weather data</td>
<td>v</td>
</tr>
<tr>
<td>SearchPanel</td>
<td>Can input city name and show multiple city results with similar name</td>
<td>v</td>
</tr>
<tr>
<td>MainPanel</td>
<td>Interract between SearchPanel and DetailPanel</td>
<td>v</td>
</tr>
<tr>
<td rowspan="4">main.java.retriever</td>
<td>WeatherRetriever</td>
<td>Retrieve weather data and save to json file</td>
<td>v</td>
</tr>
<tr>
<td>CityFinder</td>
<td>Can find city ID based on name</td>
<td>v</td>
</tr>
<tr>
<td>MainController</td>
<td>Interract between components and handle data interraction</td>
<td>v</td>
</tr>
<tr>
<td>DetailController</td>
<td>Handling weather detail data and interract with DetailPanel</td>
<td>v</td>
</tr>
</tbody>
</table>

## JDepend Result

You can as well see the detailed result on ```build/reports/jdepend/main.xml```
<table style="width: 507px; height: 249px;">
<tbody>
<tr>
<th style="width: 142px;">&nbsp;Attr. \ Package name</th>
<th style="width: 87px;">main.java&nbsp;</th>
<th style="width: 148px;">main.java.component&nbsp;</th>
<th style="width: 129px;">main.java.retriever&nbsp;</th>
</tr>
<tr>
<td style="width: 142px;">TC&nbsp;</td>
<td style="width: 87px;">1</td>
<td style="width: 148px;">7&nbsp;</td>
<td style="width: 129px;">4&nbsp;</td>
</tr>
<tr>
<td style="width: 142px;">CC</td>
<td style="width: 87px;">1&nbsp;</td>
<td style="width: 148px;">7&nbsp;</td>
<td style="width: 129px;">4&nbsp;</td>
</tr>
<tr>
<td style="width: 142px;">AC&nbsp;</td>
<td style="width: 87px;">0&nbsp;</td>
<td style="width: 148px;">0&nbsp;</td>
<td style="width: 129px;">0&nbsp;</td>
</tr>
<tr>
<td style="width: 142px;">Ca&nbsp;</td>
<td style="width: 87px;">0&nbsp;</td>
<td style="width: 148px;">1&nbsp;</td>
<td style="width: 129px;">1&nbsp;</td>
</tr>
<tr>
<td style="width: 142px;">Ce&nbsp;</td>
<td style="width: 87px;">2&nbsp;</td>
<td style="width: 148px;">8&nbsp;</td>
<td style="width: 129px;">8&nbsp;</td>
</tr>
<tr>
<td style="width: 142px;">A&nbsp;</td>
<td style="width: 87px;">0&nbsp;</td>
<td style="width: 148px;">0&nbsp;</td>
<td style="width: 129px;">0&nbsp;</td>
</tr>
<tr>
<td style="width: 142px;">I</td>
<td style="width: 87px;">1&nbsp;</td>
<td style="width: 148px;">0.89&nbsp;</td>
<td style="width: 129px;">0.89&nbsp;</td>
</tr>
<tr>
<td style="width: 142px;">D&nbsp;</td>
<td style="width: 87px;">0&nbsp;</td>
<td style="width: 148px;">0.11&nbsp;</td>
<td style="width: 129px;">0.11&nbsp;</td>
</tr>
<tr>
<td style="width: 142px;">V&nbsp;</td>
<td style="width: 87px;">1&nbsp;</td>
<td style="width: 148px;">1&nbsp;</td>
<td style="width: 129px;">1&nbsp;</td>
</tr>
</tbody>
</table>

<!-- ## Installation -->
  
## How to Use

- At first, the app will shows you the home screen. You can search for a city name on the search panel on the left side. <br> ![1](https://github.com/ahmadfahmip/weather-forecast/blob/master/screenshot/1.jpg)

- After you press "find city" button, the app will search for weather forecast corresponding to the certain city. If the data is found, the detail panel on the right will show you the 5-day forecast data. <br> ![2](https://github.com/ahmadfahmip/weather-forecast/blob/master/screenshot/2.jpg)

- You can also choose for any day you want, based on the available data by clicking the options on the bottom side. <br> ![3](https://github.com/ahmadfahmip/weather-forecast/blob/master/screenshot/3.jpg)

- When you search for a city name, there may be multiple cities exists with similar name. The app will show you multiple city results for you to be chosen further. <br> ![4](https://github.com/ahmadfahmip/weather-forecast/blob/master/screenshot/4.jpg)

- You can as well choose any city you want from the multiple results available, and have it shows the forecast data on the detail panel. <br> ![5](https://github.com/ahmadfahmip/weather-forecast/blob/master/screenshot/5.jpg)

- If a certain city name doesn't exist on the database, the app will shows error message. <br> ![6](https://github.com/ahmadfahmip/weather-forecast/blob/master/screenshot/6.jpg)
  
## Reference  

- [JSON.simple 1.1.1](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1)
- [Intellij IDEA](https://www.jetbrains.com/idea/) (optional, for compiling)
  
## Author    

Ahmad Fahmi Pratama
   
Informatics Engineering at Institut Teknologi Bandung
 
Visit my page [here](http://ahmadfahmi.me)
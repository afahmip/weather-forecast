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
**_subject to change_**

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

## How to Install  
  
  
## How to Use  
  
  
## Reference  
  
  
## Author    
Ahmad Fahmi Pratama <br>    
Informatics Engineering at Institut Teknologi Bandung <br>    
Visit my page [here](http://ahmadfahmi.me) <br>
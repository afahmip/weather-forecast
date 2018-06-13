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
            |
            └───model
                |   class Weather

```

The source code is divided into two packages. One is package _component_ that stores interface component, and package _model_ that stores weather model. Package _component_ consists of class MainFrame (the main window), class DetailPanel (panel that show weather details), and class SearchPanel (panel that has search input and feature). Package _retriever_ consists of class WeatherRetriever that handles weather scrapping data from OpenWeatherMap API and class CityFinder which returns city ID from given city name.

## Class / Feature Checklist
**_subject to change_**

<table>
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
    <td></td>
  </tr>
  <tr>
    <td rowspan="3">main.java.component</td>
    <td>MainFrame</td>
    <td>Create base component</td>
    <td></td>
  </tr>
  <tr>
    <td>DetailPanel</td>
    <td>Create base component</td>
    <td></td>
  </tr>
  <tr>
    <td>SearchPanel</td>
    <td>Create base component</td>
    <td></td>
  </tr>
  <tr>
    <td rowspan="2">main.java.retriever</td>
    <td>WeatherRetriever</td>
    <td>Create GET request method</td>
    <td></td>
  </tr>
  <tr>
    <td>CityFinder</td>
    <td>Create base class</td>
    <td></td>
  </tr>
</table>

## How to Install  
  
  
## How to Use  
  
  
## Reference  
  
  
## Author    
Ahmad Fahmi Pratama <br>    
Informatics Engineering at Institut Teknologi Bandung <br>    
Visit my page [here](http://ahmadfahmi.me) <br>
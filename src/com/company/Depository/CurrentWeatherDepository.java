package com.company.Depository;

import com.company.Request;
import com.company.Events.CurrentWeatherEvent;


public class CurrentWeatherDepository {

    private final String KEY = "3dcbd390759a473460531c2fed5b634a";

    public CurrentWeatherEvent getCurrentWeather(Request request) throws Exception {
        return new CurrentWeatherEvent(request.getUrlRequest().requestForecastData("https://api.openweathermap.org/data/2.5/find?q=" + request.getCity()
                + "," + request.getCode() + "&units="+ request.getUnits() + "&APPID=" + KEY));
    }
}

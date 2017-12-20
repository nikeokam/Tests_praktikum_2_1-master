package com.company.Depository;

import org.json.*;
import com.company.Request;
import com.company.Events.KoordWeatherEvent;


public class KoordWeatherDepository{

    private final String KEY = "3dcbd390759a473460531c2fed5b634a";

    public KoordWeatherEvent getKoordWeather(Request request) throws Exception{
        return new KoordWeatherEvent(request.getUrlRequest().requestForecastData("https://api.openweathermap.org/data/2.5/forecast?q=" + request.getCity()
                + "&APPID=" + KEY));
    }
}

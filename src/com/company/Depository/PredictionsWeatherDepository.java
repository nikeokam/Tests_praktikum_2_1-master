package com.company.Depository;

import org.json.*;
import com.company.Request;
import com.company.Events.PredictionsWeatherEvent;

import java.util.HashMap;
import java.util.Map;

public class PredictionsWeatherDepository extends Repository {
    public PredictionsWeatherEvent getPredictions(Request request) throws Exception {
        return new PredictionsWeatherEvent( request.getUrlRequest().requestForecastData("https://api.openweathermap.org/data/2.5/forecast?q=" + request.getCity()
                + "," + request.getCode() + "&APPID=" + "3dcbd390759a473460531c2fed5b634a"));

    }   }


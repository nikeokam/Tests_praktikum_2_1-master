package com.company;

import com.company.Depository.CurrentWeatherDepository;
import com.company.Depository.KoordWeatherDepository;
import com.company.Depository.PredictionsWeatherDepository;
import com.company.Events.CurrentWeatherEvent;
import com.company.Events.KoordWeatherEvent;
import com.company.Events.PredictionsWeatherEvent;

import java.awt.*;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

public class Request {
    protected Double currentTemp;
    protected String city;
    protected String code;
    protected String units = "metric";
    protected FileWrite fileWrite;
    protected UrlRequest urlRequest;

    public UrlRequest getUrlRequest() {
        return urlRequest;
    }

    public Request(String city, String code) {
        this.city = city;
        this.code = code;
    }

    public Request(String city, String code, String units) {
        this.city = city;
        this.code = code;
        this.units = units;
    }


    public Request(String city, String units, FileWrite fileWrite, UrlRequest urlRequest) {

        this.city = city;
        this.units = units;
        this.fileWrite = fileWrite;
        this.urlRequest = urlRequest;
    }

    public double getCurTemp() {
        CurrentWeatherEvent currentWeatherEvent = null;
        try {
            currentWeatherEvent = new CurrentWeatherDepository().getCurrentWeather(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.currentTemp = (currentWeatherEvent != null) ? currentWeatherEvent.getCurTemp() : 0;
        return currentTemp;
    }

    public boolean writeRequest() throws Exception {
        PredictionsWeatherEvent predictions = new PredictionsWeatherDepository().getPredictions(this);
        KoordWeatherEvent koordWeatherEvent = new KoordWeatherDepository().getKoordWeather(this);
        ArrayList<String> temperatureToWrite = new ArrayList<>(Arrays.asList(city, koordWeatherEvent.lattitude + " " + koordWeatherEvent.longitude,
                "Current temperature: ",
                Double.toString(getCurTemp()),
                "Forecast: ",
                "Day 1: " + predictions.getForecast().getJSONObject(0).getJSONObject("main").getDouble("temp_max"),
                "Day 2: " + predictions.getForecast().getJSONObject(1).getJSONObject("main").getDouble("temp_max"),
                "Day 3: " + predictions.getForecast().getJSONObject(2).getJSONObject("main").getDouble("temp_max"),
                "Current: " + predictions.getForecast().getJSONObject(0).getJSONObject("main").getDouble("temp")));
        return fileWrite.writeCurTemp(city, temperatureToWrite);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}

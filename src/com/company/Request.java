package com.company;

import com.company.Depository.CurrentWeatherDepository;
import com.company.Depository.KoordWeatherDepository;
import com.company.Depository.PredictionsWeatherDepository;
import com.company.Events.CurrentWeatherEvent;
import com.company.Events.KoordWeatherEvent;
import com.company.Events.PredictionsWeatherEvent;

import java.awt.*;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    Double GetMinMaxToTest() {
        return MinMaxToTest;
    }

    private Double MinMaxToTest;


    public boolean writeRequest() throws Exception {
            PredictionsWeatherEvent predictions = new PredictionsWeatherDepository().getPredictions(this);
        HashMap<String, Double> forecastMaxTempMap = new HashMap<>();
        HashMap<String, Double> forecastMinTempMap = new HashMap<>();
        for (int i = 0; i < 40; i ++) {
            Double fragmentTemp = predictions.getForecast().getJSONObject(i).getJSONObject("main").getDouble("temp");
            String fragmentData = predictions.getForecast().getJSONObject(i).getString("dt_txt").substring(0, 10);
            if (forecastMaxTempMap.containsKey(fragmentData) && forecastMaxTempMap.get(fragmentData) < fragmentTemp) {
                forecastMaxTempMap.put(fragmentData, fragmentTemp);
            } else if (forecastMinTempMap.containsKey(fragmentData) && forecastMinTempMap.get(fragmentData) > fragmentTemp) {
                forecastMinTempMap.put(fragmentData, fragmentTemp);
            } else {
                forecastMaxTempMap.put(fragmentData, fragmentTemp);
                forecastMinTempMap.put(fragmentData, fragmentTemp);
            }

        }

        MinMaxToTest = forecastMaxTempMap.get(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now().plusDays(1)));

        KoordWeatherEvent koordWeatherEvent = new KoordWeatherDepository().getKoordWeather(this);
        ArrayList<String> temperatureToWrite = new ArrayList<>(Arrays.asList(city, koordWeatherEvent.lattitude + " " + koordWeatherEvent.longitude,
                "Current temperature: ",
                Double.toString(getCurTemp()),
                "Forecast: ",
                "Day 1: max " + forecastMaxTempMap.get(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()))
                        + " min "+ forecastMinTempMap.get(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now())),
                "Day 2: max " + forecastMaxTempMap.get(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now().plusDays(1)))
                        + " min " + forecastMinTempMap.get(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now().plusDays(1))),
                "Day 3: max " + forecastMaxTempMap.get(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now().plusDays(2)))
                        + " min "+ forecastMinTempMap.get(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now().plusDays(2)))));

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

package com.company.Events;

import org.json.*;

public class CurrentWeatherEvent {
    protected String city;
    protected String code;

    protected Double curTemp;
    protected Double minTemp;
    protected Double maxTemp;

    public CurrentWeatherEvent(JSONObject json){
        JSONArray list = json.getJSONArray("list");
        JSONObject data = list.getJSONObject(0);

        this.city = data.getString("name");
        this.code = data.getJSONObject("sys").getString("country");

        this.curTemp = data.getJSONObject("main").getDouble("temp");
        this.minTemp = data.getJSONObject("main").getDouble("temp_min");
        this.maxTemp = data.getJSONObject("main").getDouble("temp_max");}

        public String getCity() {return city;}
        public String getCode() {return code;}
        public Double getCurTemp() {return curTemp; }
        public Double getMinTemp() {return minTemp; }
        public Double getMaxTemp() {return maxTemp; }

    @Override
    public String toString() {
        return "CurrentWeatherReport{" +
                "city='" + city + '\'' +
                ", code='" + code + '\'' +
                ", currentTemperature=" + curTemp +
                ", minimalTemperature=" + minTemp +
                ", maximumTemperature=" + maxTemp +
                '}';
    }
}


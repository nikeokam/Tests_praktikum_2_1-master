package com.company.Events;

import org.json.JSONArray;
import org.json.JSONObject;

public class KoordWeatherEvent {
    public String lattitude;
    public String longitude;
    public KoordWeatherEvent(JSONObject json) {
        System.out.println(json.toString());
        JSONObject data = json.getJSONObject("city");


        this.lattitude = Double.toString(data.getJSONObject("coord").getDouble("lat"));
        this.longitude = Double.toString(data.getJSONObject("coord").getDouble("lon"));

    }
}

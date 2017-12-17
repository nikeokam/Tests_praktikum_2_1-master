package com.company.Events;

import org.json.JSONArray;
import org.json.JSONObject;

public class PredictionsWeatherEvent {

    public JSONArray getForecast() {
        return forecast;
    }

    private JSONArray forecast;

    public PredictionsWeatherEvent(JSONObject jsonObject) {
        this.forecast = jsonObject.getJSONArray("list");
    }
}

package com.company.Depository;

import com.company.Events.PredictionsWeatherEvent;
import com.company.FileWrite;
import com.company.Request;
import com.company.UrlRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredictionsWeatherDepositoryTest {
    @Test
    public void testPredictions() {
        try{
            Request request = new Request("Tallinn", "metric", new FileWrite(), new UrlRequest());
            com.company.Depository.PredictionsWeatherDepository depository = new com.company.Depository.PredictionsWeatherDepository();

            PredictionsWeatherEvent prediction = depository.getPredictions(request);

            assertNotNull(prediction.getForecast());

        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
    private void asserztEquals(String code, String code1){

    }

}
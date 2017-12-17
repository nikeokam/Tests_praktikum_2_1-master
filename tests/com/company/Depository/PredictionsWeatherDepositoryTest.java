package com.company.Depository;

import com.company.Events.PredictionsWeatherEvent;
import com.company.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredictionsWeatherDepositoryTest {
    @Test
    public void testPredictions() {
        try{
            Request request = new Request("Tallinn", "EE", "metric");
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
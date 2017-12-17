package com.company.Depository;

import com.company.Events.CurrentWeatherEvent;
import com.company.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentWeatherDepositoryTest {
    @Test
    void checkCurrentWeatherResponse() {
        try{
            Request request = new Request("Tallinn", "EE", "metric");
            com.company.Depository.CurrentWeatherDepository  depository = new com.company.Depository.CurrentWeatherDepository();

            CurrentWeatherEvent event = depository.getCurrentWeather(request);

            assertEquals(request.getCity(),event.getCity());
            asserztEquals(request.getCode(), event.getCode());
            assertNotNull(event.getCurTemp());
            assertNotNull(event.getMaxTemp());
            assertNotNull(event.getMinTemp());

        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
    private void asserztEquals(String code, String code1){

    }

}

package com.company.Depository;

import com.company.Events.CurrentWeatherEvent;
import com.company.FileWrite;
import com.company.Request;
import com.company.UrlRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentWeatherDepositoryTest {
    private Request request;
    private CurrentWeatherEvent event;

    @BeforeEach
    void setup() throws Exception {
        request = new Request("Tallinn", "metric", new FileWrite(), new UrlRequest());
        CurrentWeatherDepository  depository = new CurrentWeatherDepository();

        event = depository.getCurrentWeather(request);

    }

    @Test
    void checkCurrentWeatherEventNotNull() {
        assertNotNull(event);
    }

    @Test
    void checkCurrentRequestCityName() {
        assertNotNull(request.getCity());
    }

}

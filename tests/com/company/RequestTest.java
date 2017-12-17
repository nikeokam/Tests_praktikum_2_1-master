package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {
    @Test
    void outputFile () throws Exception {
        Request request = new Request("Riga", "Metric", new FileWrite(), new UrlRequest());

        request.writeRequest();

        try{
            assertNotNull(Files.readAllBytes(Paths.get("/Users/nikitaokamanchuk/Desktop/Tests_praktikum_2_1-master/src/com/company/Tallinn.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
package com.company;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileReadTest {
    void test_mockFileRead() throws Exception {
        FileRead filesMock = mock(FileRead.class);

        when(filesMock.readData()).thenReturn("Madrid");

        AddCityNames massReport1 = new AddCityNames(new UrlRequest(), new FileWrite(), filesMock);
        massReport1.generateDataFiles();
        if (Files.notExists(Paths.get("/Users/nikitaokamanchuk/Desktop/Tests_praktikum_2_1-master/src/com/company/Tallinn.txt"))) {
            fail("File not found.");
        }

    }
}
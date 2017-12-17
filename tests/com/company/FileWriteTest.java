package com.company;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileWriteTest {
    void MockTestFileWrite() throws Exception {
        FileWrite filesMock = mock(FileWrite.class);

        when(filesMock.writeCurTemp(anyString(), any())).thenReturn(true);

        String filename = new String(Files.readAllBytes(Paths.get("/Users/nikitaokamanchuk/Desktop/Tests_praktikum_2_1-master/src/com/company/Tallinn.txt")));

        AddCityNames massReport1 = new AddCityNames(new UrlRequest(), filesMock, new FileRead());
        massReport1.generateDataFiles();
        if (!Files.notExists(Paths.get("/Users/nikitaokamanchuk/Desktop/Tests_praktikum_2_1-master/src/com/company/" + filename + ".txt"))){
            fail("File not found.");
        }
    }

}


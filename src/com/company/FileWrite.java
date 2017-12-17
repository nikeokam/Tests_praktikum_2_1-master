package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWrite {
        public boolean writeCurTemp(String city, ArrayList dataToWrite) {
            try {
                Files.write(Paths.get("/Users/nikitaokamanchuk/Desktop/Tests_praktikum_2_1-master/src/com/company/" + city + ".txt"),
                        dataToWrite);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }


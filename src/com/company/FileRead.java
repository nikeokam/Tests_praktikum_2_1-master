package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileRead {
        public String readData() {

            String fileData = "";
            try {
                fileData = new String(Files.readAllBytes(Paths.get("/Users/nikitaokamanchuk/Desktop/Tests_praktikum_2_1-master/src/com/company/input.txt")));
                fileData = fileData.replace("\n", ",");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return fileData;
        }
}

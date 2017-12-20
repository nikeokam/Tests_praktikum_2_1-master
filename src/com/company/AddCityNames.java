package com.company;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class AddCityNames {

    private ArrayList<Request> requests = new ArrayList<>();
    private String cityList;
    private FileWrite writer;
    private FileRead reader;
    private UrlRequest urlRequest;


    AddCityNames(UrlRequest urlRequest, FileWrite writer,
                 FileRead reader){
        this.urlRequest = urlRequest;
        this.reader = reader;
        this.writer = writer;
        cityList = this.reader.readData();

        createRequests();
    }
    public void generateDataFiles() throws Exception {
        for(Request request : requests){
            request.writeRequest();
        }
    }

    private void createRequests(){
        ArrayList<String> cityNameList = new ArrayList<>(Arrays.asList(cityList.split(",")));

        for (String city : cityNameList){
            requests.add(new Request(city,"Metric", writer, urlRequest));
        }
    }
}

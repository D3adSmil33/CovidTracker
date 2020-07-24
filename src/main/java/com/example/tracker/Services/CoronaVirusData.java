package com.example.tracker.Services;

import com.example.tracker.Model.States;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusData {

    HttpURLConnection connetion;
    private static String linkAPI = "https://covidtracking.com/api/states";

    private long totalCases = 0;

    public long getTotalCases() {
        return totalCases;
    }

    private List<States> allStates = new ArrayList<>();

    public List<States> getAllStates() {
        return allStates;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchData() {

        try{

            URL url = new URL(linkAPI);
            connetion = (HttpURLConnection) url.openConnection();
            connetion.setRequestMethod("GET");
            connetion.setConnectTimeout(5000);
            connetion.setReadTimeout(5000);

            int status = connetion.getResponseCode();

            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();

            if(status  > 299){
                reader = new BufferedReader(new InputStreamReader(connetion.getErrorStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader((connetion.getInputStream())));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }

            if (responseContent != null) {
                parseJSON(responseContent.toString());
            }

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            connetion.disconnect();
        }

    }

    public String parseJSON(String responseBody){

        JSONArray albums = new JSONArray(responseBody);

        List<States> newStates = new ArrayList<>();

        for(int i = 0; i < albums.length(); i++){

            States state = new States();

            JSONObject album = albums.getJSONObject(i);
            state.setState(album.getString("state"));
            state.setPositive(album.getLong("positive"));

            totalCases += state.getPositive();

            state.setNegative(album.getLong("negative"));

            StringBuilder recovered = new StringBuilder();
            try {
                recovered.append(album.getLong("recovered"));
            } catch (Exception e){
                recovered.append("undefined");
            }

            state.setRecovered(recovered.toString());

            newStates.add(state);
        }
        this.allStates = newStates;

        return null;
    }

}

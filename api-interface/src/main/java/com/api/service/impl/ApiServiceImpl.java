package com.api.service.impl;

import com.api.service.ApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ApiServiceImpl implements ApiService {

    @Value("${openId.weather}")
    private String openIdWeather;

    @Value("${openId.deilyEnglish}")
    private String openIdDeilyEnglish;

    @Override
    public String weatherQuery(Map<String, String> map) {
        String apiUrl = "http://apis.juhe.cn/simpleWeather/query";

        map.put("key", openIdWeather);
        map.put("city", map.get("city"));

        StringBuffer response;
        try {
            URL url = new URL(String.format("%s?%s", apiUrl, params(map)));
            BufferedReader in = new BufferedReader(new InputStreamReader((url.openConnection()).getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.toString();
    }

    public static String params(Map<String, String> map) {
        return map.entrySet().stream()
                .map(entry -> {
                    try {
                        return entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return entry.getKey() + "=" + entry.getValue();
                    }
                })
                .collect(Collectors.joining("&"));
    }

    @Override
    public String dailyEnglish() {
        String apiUrl = "http://apis.juhe.cn/fapigx/everyday/query";

        HashMap<String, String> map = new HashMap<>();
        map.put("key", openIdDeilyEnglish);

        StringBuffer response;
        try {
            URL url = new URL(String.format("%s?%s", apiUrl, params(map)));
            BufferedReader in = new BufferedReader(new InputStreamReader((url.openConnection()).getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.toString();
    }
}

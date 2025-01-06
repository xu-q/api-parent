package com.api.service;

import java.util.HashMap;
import java.util.Map;

public interface ApiService {

    String weatherQuery(HashMap<String, String> map);

    String dailyEnglish();
}

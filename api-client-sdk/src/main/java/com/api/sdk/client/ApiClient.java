package com.api.sdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.api.sdk.model.User;
import com.api.sdk.utils.SignUtil;

import java.util.HashMap;
import java.util.Map;

public class ApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8082/";

    private String accessKey;

    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String weatherQuery(String city) {
        Map<String, String> params = new HashMap<>();
        params.put("city", city);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "api/weatherQuery")
                .addHeaders(buildHeaderMap())
                .body(JSONUtil.toJsonStr(params))
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    private Map<String, String> buildHeaderMap() {
        Map<String, String> map = new HashMap<>();
        map.put("accessKey", accessKey);
        map.put("secretKey", secretKey);
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("nonce", RandomUtil.randomNumbers(4));
        headerMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        headerMap.put("sign", SignUtil.getSign(map));
        headerMap.put("accessKey", accessKey);
        headerMap.put("secretKey", secretKey);
        return headerMap;
    }
}

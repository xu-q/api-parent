package com.api.sdk;

import com.api.sdk.utils.SignUtil;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("accessKey", "xuqing");
        map.put("secretKey", "a1b2c3d4");
        System.out.println(SignUtil.getSign(map));
    }

}

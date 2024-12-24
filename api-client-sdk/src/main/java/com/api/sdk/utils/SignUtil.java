package com.api.sdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.util.Map;

public class SignUtil {
    public static String getSign(Map<String, String> map) {
        Digester digester = new Digester(DigestAlgorithm.SHA256);
        return digester.digestHex(map.toString() + map.get("secretKey"));
    }
}

package com.api.controller;

import com.api.service.ApiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping()
public class ApiController {

    @Resource
    private ApiService apiService;

    @PostMapping("/weatherQuery")
    public String weatherQuery(@RequestBody Map<String, String> map) {
        return apiService.weatherQuery(map);
    }
}

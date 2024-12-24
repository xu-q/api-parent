package com.api;

import com.api.sdk.client.ApiClient;
import com.api.sdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

    // 注入一个名为yuApiClient的Bean
    @Resource
    private ApiClient apiClient;

    // 表示这是一个测试方法
    @Test
    void testApiSdk() {
        //String result = apiClient.getNameByGet("yupi");
        //System.out.println(result);
        User user = new User();
        user.setName("214324");
        String usernameByPost = apiClient.getUserByPost(user);
        System.out.println(usernameByPost);
    }


}

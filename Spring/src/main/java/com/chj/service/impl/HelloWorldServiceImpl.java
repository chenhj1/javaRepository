package com.chj.service.impl;

import com.chj.service.HelloWorldService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Created by chenhaojie on 2018/02/11.
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService{
    @Override
    public JSONObject SayHelloWorld(String key) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",key);
        return jsonObject;
    }
}

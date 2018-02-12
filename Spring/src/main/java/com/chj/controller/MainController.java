package com.chj.controller;

import com.chj.dao.LayoutDao;
import com.chj.service.HelloWorldService;
import com.chj.service.PropertyService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    @Autowired
    public PropertyService propertyService;

    @Autowired
    public HelloWorldService helloWorldService;

    @Autowired
    private LayoutDao layoutDao;

    private static Logger logger = Logger.getLogger(MainController.class);

    @PostConstruct
    public void init(){
        logger.info("init!!");
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public Object login(String key){
        String value = propertyService.getProperty(key);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","success");
        jsonObject.put("key",value);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/hello")
    public Object hellowordAspect(HttpServletRequest httpServletRequest,String key){

        JSONObject jsonObject = helloWorldService.SayHelloWorld(key);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/cards")
    public Object cards(String id,
                        String channelId){
        Map<String,String>paramsMap = new HashMap<>();
        paramsMap.put("id",id);
        paramsMap.put("channel_id",channelId);
        List<Map<String,String>> resultList = layoutDao.cards(paramsMap);
        return JSONArray.fromObject(resultList);
    }

}

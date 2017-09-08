package com.chj.controller;

import com.chj.service.PropertyService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    @Autowired
    public PropertyService propertyService;

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

}

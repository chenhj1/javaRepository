package com.chj.controller;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    private static Logger logger = Logger.getLogger(MainController.class);

    @PostConstruct
    public void init(){
        logger.info("init!!");
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public Object login(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","success");
        return jsonObject;
    }

}

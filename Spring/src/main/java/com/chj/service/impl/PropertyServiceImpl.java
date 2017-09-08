package com.chj.service.impl;

import com.chj.service.PropertyService;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Properties;

@Service
public class PropertyServiceImpl implements PropertyService{

    private static Properties properties;

    static {
        properties = getConfig();
    }

    private static Properties getConfig() {
        String filePath = "/property.properties";
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            inputStream = PropertyService.class.getResourceAsStream(filePath);
            prop.load(inputStream);

            if (inputStream != null) inputStream.close();
        } catch (Exception e) {
        }
        return prop;
    }

    @Override
    public String getProperty(String key) {
        String value = properties.getProperty(key);
        return value;
    }

    @Test
    public void test(){
        System.out.println(getProperty("key2"));
    }
}

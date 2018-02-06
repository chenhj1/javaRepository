package com.chj.dao;

import com.chj.mapper.LayoutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by chenhaojie on 2018/02/06.
 */
@Repository
public class LayoutDao {

    @Autowired
    LayoutMapper layoutMapper;

    public List<Map<String, String>> cards(Map<String,String>paramsMap){
        return layoutMapper.cards(paramsMap);
    }
}

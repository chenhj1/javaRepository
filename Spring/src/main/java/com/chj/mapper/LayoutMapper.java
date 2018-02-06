package com.chj.mapper;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by chenhaojie on 2018/02/06.
 */
@Repository
public interface LayoutMapper {
    List<Map<String,String>> cards(Map<String,String>paramsMap);
}

package com.bccoder.mybatis.data.page;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PageDataFormat {
    //当前页
    private int page;
    //每页显示条数
    private int rows;

    public static  String formattMap(Page p){
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("total",p.getTotalCount());
        jsonMap.put("rows",p.getData());
        String str = JSONObject.toJSONString(jsonMap, SerializerFeature.WriteMapNullValue,SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat);
        return str;
    }
}

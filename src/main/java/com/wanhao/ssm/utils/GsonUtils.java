package com.wanhao.ssm.utils;

import com.google.gson.Gson;

/**
 * Created by LiuLiHao on 2018/7/21 13:38.
 * desc： convert object to json string
 * author： LiuLiHao
 */
public class GsonUtils {

    //singleton mode
    private static final Gson gson = new Gson();

    /**
     * 2json
     * @param object
     * @return
     */
    public static String toJson(Object object){
        return gson.toJson(object);
    }

}

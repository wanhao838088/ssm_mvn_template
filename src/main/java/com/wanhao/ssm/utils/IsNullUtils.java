package com.wanhao.ssm.utils;

import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by LiuLiHao on 2018/7/21 11:48.
 * 描述： 判断字段是否为空
 * 作者： LiuLiHao
 */

public class IsNullUtils {

    /**
     * 判空
     * @return 为空返回 true 为空返回 false
     */
    public static boolean isContainsNull(String... arr){
        if (arr!=null && arr.length>0){
            for (int i=0;i<arr.length;i++){
                String s = arr[i];
                if (StringUtils.isBlank(s)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否为空
     * @return 为空返回 true
     *         非空返回 false
     */
    public static boolean isNull(Object... arr){
        if (arr!=null && arr.length>0){
            for (int i=0;i<arr.length;i++){
                Object o = arr[i];

                if (o instanceof String && StringUtils.isBlank((String) o)){
                    return true;
                }
                else if (o==null){
                    return true;
                }

            }
        }
        return false;
    }

    //list  判断
    public static boolean listIsNull(List list){
        return  list==null || list.size()==0;
    }

    public static boolean listIsNotNull(List list){
        return list!=null && list.size()>0;
    }

    //数组  判断
    public static boolean arrayIsNull(Object[] arr){
        return  arr==null || arr.length==0;
    }

    public static boolean arrayIsNotNull(Object[] arr){
        return arr!=null && arr.length>0;
    }


        /**
         * 是否不为空
         * @return
         */
    public static boolean isNotNull(Object... arr){
        if (arr!=null && arr.length>0){
            for (int i=0;i<arr.length;i++){
                Object o = arr[i];

                if (o instanceof String && StringUtils.isBlank((String) o)){
                    return false;
                }else if (o==null){
                    return false;
                }

            }
        }
        return true;
    }

    /**
     * 判空
     * @return 为空返回 true
     *         非空返回 false
     */
    public static boolean isNullWithResponse(HttpServletResponse response, Object... arr){
        boolean flag = false;
        if (arr!=null && arr.length>0){
            for (int i=0;i<arr.length;i++){
                Object o = arr[i];

                if (o instanceof String && StringUtils.isBlank((String) o)){
                    flag =  true;
                    break;
                }else if (o==null){
                    flag =  true;
                    break;
                }

            }
        }

        if (flag){
            JsonObject jsonObject = new JsonObject();
            ResponseUtils.retnFailMsg(response,jsonObject);
            return flag;
        }

        return false;
    }
}

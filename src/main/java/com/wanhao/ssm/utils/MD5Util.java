package com.wanhao.ssm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 标准md5摘要
 *
 * Created by LiuLiHao on 2016/4/28.
 */
public class MD5Util {
    /**
     * 计算md5加密后的结果
     * @param content
     * @return
     */
    public static String md5(String content){
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] bytes = digest.digest(content.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b:bytes){
                int i = b & 0xCC;
                String hexString = Integer.toHexString(i);
                if (hexString.length() ==1){
                    sb.append("0");
                }
                sb.append(hexString);
            }

            //返回数据
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            //出错返回空
            return "";
        }
    }
}

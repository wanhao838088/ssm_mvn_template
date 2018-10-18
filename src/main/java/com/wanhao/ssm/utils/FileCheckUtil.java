package com.wanhao.ssm.utils;

import net.sf.jmimemagic.*;

/**
 * Created by LiuLiHao on 2018/7/25 10:51.
 * 描述： 文件检查
 * 作者： LiuLiHao
 */
public class FileCheckUtil {
    public static String getFileMimeType(byte[] bytes){
        MagicMatch match = null;
        try {
            match = Magic.getMagicMatch(bytes);
        } catch (MagicParseException e) {
            e.printStackTrace();
        } catch (MagicMatchNotFoundException e) {
            e.printStackTrace();
        } catch (MagicException e) {
            e.printStackTrace();
        }
        return match.getMimeType();
    }

}

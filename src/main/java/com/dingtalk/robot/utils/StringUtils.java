package com.dingtalk.robot.utils;

/**
 * Created by: qiliu
 * Date: 2018/12/28
 * Description:
 */
public class StringUtils {
    public static boolean isBlank(String str){
        return null == str || str.length() == 0;
    }
    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }
}

package com.sakura.medical.common.utils;

/**
 * @author 李七夜
 * Created by 李七夜 on 2020/7/17 17:25
 */
public class ObjectTools {

    private ObjectTools() {

    }

    public static boolean isBlank(Object o) {
        return CommonsUtil.isBlank(o);
    }

    public static boolean isNotBlank(Object o) {
        return CommonsUtil.isNotBlank(o);
    }

}

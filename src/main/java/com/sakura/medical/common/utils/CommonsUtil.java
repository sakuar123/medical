package com.sakura.medical.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 李七夜
 */
@Slf4j
public class CommonsUtil {


    /**
     * 判断对象是否为空,为空返回true,非空为false
     */
    public static boolean isBlank(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof Optional) {
            return !((Optional) o).isPresent();
        }
        // 字符串
        if (o instanceof CharSequence) {
            return StringUtils.isBlank((CharSequence) o);
        }
        // 数组
        if (o.getClass().isArray()) {
            return Array.getLength(o) == 0;
        }
        // 集合
        if (o instanceof Collection) {
            return ((Collection) o).isEmpty();
        }
        // Map
        if (o instanceof Map) {
            return ((Map) o).isEmpty();
        }
        return false;
    }

    /**
     * 判断对象是否不为空,为空返回false,不为空返回true
     */
    public static boolean isNotBlank(Object o) {
        return !isBlank(o);
    }

    public static void main(String[] args) {
        log.info(JSON.toJSONString(getIdentityInfoByIdCard("210103198809017449")));
    }

    /**
     * 获取指定长度的纯随机数
     */
    public static Long getRandomNumber(int length) {
        //生成一个指定长度的随机数
        String randonNum = RandomStringUtils.random(length, false, true);
        //这个随机数第一位可能是0,parse的时候会被自动格式掉,不符合我们需要长度的字符串
        //所以这里做个处理,如果生成的随机数第一位是0,则自动替换1-9之间的一个随机数
        if ("0".equals(randonNum.substring(0, 1))) {
            int x = 1, y = 9;
            int t = x + (int) (Math.random() * (y + 1 - 2));
            randonNum = randonNum.replaceFirst("0", StringUtils.join(t));
        }
        return parseLong(randonNum);
    }

    /**
     * 获取一个随机字符串
     */
    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    /**
     * 获取ip地址
     */
    public static String getLocalIP() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        byte[] ipAddr = Objects.requireNonNull(addr).getAddress();
        StringBuilder ipAddrStr = new StringBuilder();
        for (int i = 0; i < ipAddr.length; i++) {
            if (i > 0) {
                ipAddrStr.append(".");
            }
            ipAddrStr.append(ipAddr[i] & 0xFF);
        }
        return ipAddrStr.toString();
    }

    /**
     * 通过身份证号获取身份信息
     * 出生日期,性别
     */
    public static PageData getIdentityInfoByIdCard(String certificateNo) {

        boolean checkIdentityInfoResult = checkIdentityInfo(certificateNo);
        if (!checkIdentityInfoResult) {
            return null;
        }

        String birthday = "";
        String age = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = certificateNo.toCharArray();
        boolean flag = true;

        for (int x = 0; x < (number.length == 15 ? number.length : number.length - 1); x++) {
            flag = Character.isDigit(number[x]);
        }

        if (flag && certificateNo.length() == 15) {
            birthday = "19" + certificateNo.substring(6, 8) + "-"
                    + certificateNo.substring(8, 10) + "-"
                    + certificateNo.substring(10, 12);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length())) % 2
                    == 0 ? "F" : "M";
            age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
        } else if (flag && certificateNo.length() == 18) {
            birthday = certificateNo.substring(6, 10) + "-"
                    + certificateNo.substring(10, 12) + "-"
                    + certificateNo.substring(12, 14);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1))
                    % 2 == 0 ? "0" : "1";
            age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
        }

        PageData pd = new PageData();
        pd.put("birthday", birthday);
        pd.put("age", age);
        pd.put("sexCode", sexCode);
        return pd;
    }

    public static String parseString(String src) {
        return isBlank(src) ? "" : src.trim();
    }

    public static int parseInt(String s) {
        return parseInt(s, 0);
    }

    public static int parseInt(String s, int defaultValue) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static long parseLong(String s) {
        return parseLong(s, 0L);
    }

    public static long parseLong(String s, long defaultValue) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Double parseDouble(String value) {
        return parseDouble(value, 0.0);
    }

    public static double parseDouble(String s, Double defaultValue) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 获取一段随机字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 返回一段json信息输出打印到控制台上
     */
    public static void returnResult(JsonResult<Object> jsonResult, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(jsonResult.toJsonString());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 校验邮箱
     */
    public static Boolean checkEmail(String email) {
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return Pattern.compile(check).matcher(email).find();
    }

    /**
     * 校验身份证号
     */
    public static Boolean checkIdentityInfo(String identityInfo) {
        if (isBlank(identityInfo)) {
            return false;
        }
        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾
        String regularExpression =
                "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                        "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        boolean matches = Pattern.compile(regularExpression).matcher(identityInfo).find();
        if (!matches) {
            return false;
        }

        if (identityInfo.length() == 18) {
            try {
                char[] charArray = identityInfo.toCharArray();
                //前十七位加权因子
                int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                //这是除以11后，可能产生的11位余数对应的验证码
                String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                int sum = 0;
                for (int i = 0; i < idCardWi.length; i++) {
                    int current = Integer.parseInt(String.valueOf(charArray[i]));
                    int count = current * idCardWi[i];
                    sum += count;
                }
                char idCardLast = charArray[17];
                int idCardMod = sum % 11;
                if (idCardY[idCardMod].equalsIgnoreCase(String.valueOf(idCardLast).toUpperCase())) {
                    return true;
                }
            } catch (Exception e) {
                log.error(e.getMessage());
                return false;
            }
        }
        return false;
    }
}

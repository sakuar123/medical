package com.sakura.medical.common.utils;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by 李七夜 on 2020/5/8 17:47
 *
 * @author 李七夜
 */
@Slf4j
public class JwtUtil {

    private static final String USER_NAME = "userName";

    /** 失效时间,默认为1个小时 */
    private static final Date EXPIRATION_TIME = DateUtils.addHours(new Date(), +1);

    /** 生成签名的时候使用的秘钥secret */
    private static final String JWT_KEY = "NBMcTwQaqkJnPzs9zhwWusoRIiKiPaFIxO8m6heDIdvgRX4unbzNp0rM8XE3s6Er";

    /**
     * 生成jwt
     */
    public static String createJwt(String user) {
        return createJwt(EXPIRATION_TIME, user);
    }

    /**
     * 用户登录成功后生成Jwt
     * 使用Hs256算法  私匙使用用户密码
     *
     * @param expirationDate jwt过期时间
     * @param user 登录成功的user对象
     */
    public static String createJwt(Date expirationDate, String user) {
        JSONObject jsonObject = JSON.parseObject(user);
        //指定签名的时候使用的签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成签发人,签发人为当前生成jwtToken的用户
        String subject = jsonObject.getString(USER_NAME);

        //下面就是在为payload添加各种标准声明和私有声明了
        //这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //设置私有声明,私有声明即我们放入JWT载荷里的信息,不同于共有的声明,私有声明可以由我们自定义内容
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(jsonObject)
                //设置jti(JWT ID)：是JWT的唯一标识，主要用来作为一次性token,从而回避重放攻击。
                //一个随机长度为10位的纯数字+当前系统的时间戳
                .setId(StringUtils.join(CommonsUtil.getRandomNumber(10).toString(), System.currentTimeMillis()))
                //iat: jwt的签发时间,取当前时间
                .setIssuedAt(new Date())
                //代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串
                .setSubject(subject)
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, JWT_KEY)
                //失效时间
                .setExpiration(expirationDate);
        return builder.compact();
    }


    /**
     * Token的解密
     *
     * @param token JWT生成的token
     */
    public static Claims parseJwt(String token) {
        try {
            return Jwts.parser()
                    //设置签名的秘钥
                    .setSigningKey(JWT_KEY)
                    //设置需要解析的jwt
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            log.error("解密token时异常:", e);
            return e.getClaims();
        }
    }

    public static void main(String[] args) {

    }
}

package com.sakura.medical.core.listen;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.sakura.medical.common.utils.CommonsUtil;

import lombok.extern.slf4j.Slf4j;


/**
 * SpringBoot全局监听器:监听到SpringBoot启动完成的时候
 * @author 李七夜
 */
@Slf4j
@Component
public class SpringBootStartListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * SpringBoot启动完成后执行的方法
     * @param applicationReadyEvent
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        servletContext.setAttribute("session", 1);
        //方便测试,项目启动完成后所有的权限会自动更新到超级管理员上,其它的会放到redis里
        ConfigurableApplicationContext applicationContext = applicationReadyEvent.getApplicationContext();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String serverPort = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        String projectName = environment.getProperty("server.name");
        String env = environment.getProperty("server.env");
        if (CommonsUtil.isBlank(contextPath)) {
            contextPath = "/";
        }
        log.info("SpringBoot启动成功.....");
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '" + projectName + "' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}{}\n\t" +
                        "{}\n\t" +
                        "Environment: \t\t{}" +
                        "\n----------------------------------------------------------",
                serverPort,
                contextPath,
                "Swagger: \t\thttp://localhost:" + serverPort + contextPath
                        + ("/".equals(contextPath) ? "" : "/")
                        + "swagger-ui.html", env);
    }

}

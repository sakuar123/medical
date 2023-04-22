package com.sakura.medical.core.listen;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.sakura.medical.common.utils.ObjectTools;

import lombok.extern.slf4j.Slf4j;

/**
 * springBoot全局监听器:监听程序销毁的时候
 * @author 李七夜
 */
@Slf4j
@Component
public class SpringBootEndListener implements ApplicationListener<ContextClosedEvent> {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        Set<String> keys = redisTemplate.keys("*");
        if (ObjectTools.isNotBlank(keys)) {
            redisTemplate.delete(keys);
        }
        log.info("SpringBoot销毁成功。");
    }
}

package com.soft.park.config;

import com.soft.park.service.IOrderByService;
import com.soft.park.service.IProfessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/7/9 13:58
 * @description
 */
@Slf4j
public class KeyExpiredListener extends KeyExpirationEventMessageListener{
    @Autowired
    private IProfessionService iProfessionService;

    @Autowired
    private IOrderByService iOrderByService;

    // ANSI转义码
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    public KeyExpiredListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println(ANSI_RED+"监听到了啥没"+ANSI_RESET);
        String expireKey = message.toString();
        log.info(ANSI_RED + "过期的key：" + expireKey + ANSI_RESET);
    }
}

package com.soft.park.scheduled;

import com.soft.park.entity.ProfessionEntity;
import com.soft.park.service.IProfessionService;
import com.soft.park.utils.RedisUtils;
import com.soft.park.vo.ProfessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/7/9 14:00
 * @description
 */
@Component
public class OrderTimeTask {
    @Autowired
    private IProfessionService iProfessionService;

    // ANSI转义码
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";

    @Scheduled(cron = "0/10 * * * * ?")
    public void newQueryOrderTime() {
        System.out.println(ANSI_BLUE + "开始扫数据了" + ANSI_RESET);
        List<ProfessionEntity> expiredOrder = iProfessionService.getExpiredOrder(new ProfessionVO());
        expiredOrder.forEach(item -> {
            RedisUtils.get().set(String.valueOf(item.getId()), item.getProfessionName());
            Duration duration = Duration.between(item.getOrderTime(), LocalDateTime.now());
            RedisUtils.get().expire(String.valueOf(item.getId()),duration);
        });
    }

}

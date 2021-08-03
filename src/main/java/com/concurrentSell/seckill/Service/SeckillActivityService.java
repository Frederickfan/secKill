package com.concurrentSell.seckill.Service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SeckillActivityService {

    @Resource
    private RedisService service;

    public boolean seckillStockValidator(long activityId) {
        String key = "stock: " + activityId;
        return service.stockDeductValidator(key);
    }
}

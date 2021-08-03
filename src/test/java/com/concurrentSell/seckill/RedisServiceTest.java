package com.concurrentSell.seckill;

import com.concurrentSell.seckill.Service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisServiceTest {

    @Resource
    RedisService redisService;

    @Test
    void setValue() {
        String value = redisService.setValue("test: 1", 100L).getValue("test: 1");
        assertEquals(Long.valueOf(value), 100L);
    }

    @Test
    void getValue() {
        String value = redisService.getValue("test: 1");
        assertEquals(Long.valueOf(value), 100L);
    }

    @Test
    void stockDeductValidator() {
        boolean result = redisService.stockDeductValidator("test: 1");
        assertTrue(result);
        String value = redisService.getValue("test: 1");
        assertEquals(Long.valueOf(value), 99L);
    }
}
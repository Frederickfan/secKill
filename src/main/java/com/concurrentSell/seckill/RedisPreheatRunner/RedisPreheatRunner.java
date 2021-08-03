package com.concurrentSell.seckill.RedisPreheatRunner;

import com.concurrentSell.seckill.Service.RedisService;
import com.concurrentSell.seckill.Service.SeckillActivityService;
import com.concurrentSell.seckill.db.dao.SeckillActivityDao;
import com.concurrentSell.seckill.db.po.SeckillActivity;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RedisPreheatRunner implements ApplicationRunner {

    @Resource
    private SeckillActivityDao seckillActivityDao;

    @Resource
    private RedisService redisService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<SeckillActivity> seckillActivityList = seckillActivityDao.querySeckillActivitysByStatus(1);
        for (SeckillActivity activity : seckillActivityList) {
            redisService.setValue("stock: " + activity.getId(), (long) activity.getAvailableStock());
        }
    }
}

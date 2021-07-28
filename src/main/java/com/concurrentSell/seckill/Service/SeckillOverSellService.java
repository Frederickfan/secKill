package com.concurrentSell.seckill.Service;

import com.concurrentSell.seckill.db.dao.SeckillActivityDao;
import com.concurrentSell.seckill.db.po.SeckillActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillOverSellService {
    @Autowired
    private SeckillActivityDao seckillActivityDao;

    public String processSeckill(long activityId) {
        SeckillActivity seckillActivity = seckillActivityDao.querySeckillActivityById(activityId);
        int availableStock = seckillActivity.getAvailableStock();
        String result;

        if (availableStock > 0) {
            result = "Buy succeed!";
            System.out.println(result);
            availableStock--;
            seckillActivity.setAvailableStock(availableStock);
            seckillActivityDao.updateSeckillActivity(seckillActivity);
        } else {
            result = "Failed to buy.";
            System.out.println(result);
        }

        return result;
    }
}

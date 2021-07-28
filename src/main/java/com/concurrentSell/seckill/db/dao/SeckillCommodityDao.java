package com.concurrentSell.seckill.db.dao;

import com.concurrentSell.seckill.db.po.SeckillCommodity;

public interface SeckillCommodityDao {

    public SeckillCommodity querySeckillCommodityById(long commodityId);
}

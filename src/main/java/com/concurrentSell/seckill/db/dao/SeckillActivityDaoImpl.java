package com.concurrentSell.seckill.db.dao;

import com.concurrentSell.seckill.db.mappers.SeckillActivityMapper;
import com.concurrentSell.seckill.db.po.SeckillActivity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SeckillActivityDaoImpl implements SeckillActivityDao {

    @Resource
    private SeckillActivityMapper seckillActivityMapper;

    @Override
    public List<SeckillActivity> querySeckillActivitysByStatus(int activityStatus) {
        return seckillActivityMapper.querySeckillActivitysByStatus(activityStatus);
    }

    @Override
    public void inertSeckillActivity(SeckillActivity seckillActivity) {
        seckillActivityMapper.insert(seckillActivity);
    }

    @Override
    public SeckillActivity querySeckillActivityById(long activityId) {
        return seckillActivityMapper.selectByPrimaryKey(activityId);
    }

    @Override
    public void updateSeckillActivity(SeckillActivity seckillActivity) {
        seckillActivityMapper.updateByPrimaryKey(seckillActivity);
    }
}

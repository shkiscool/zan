package com.jiao.service.impl;

import com.jiao.pojo.dao.Zan;
import com.jiao.pojo.mapper.ZanMapper;
import com.jiao.service.ZanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZanServiceImpl implements ZanService {

    @Autowired
    private ZanMapper zanMapper;

    @Override
    public synchronized void addCount() {
        Zan zan = zanMapper.selectByPrimaryKey(1);
        long count = zan.getCount();
        if (count <= 500) {
            count = count + (int) (50 * (Math.random()));
        } else if (500 < count && count <= 1000) {
            count = count + (int) (20 * (Math.random()));
        } else if (1000 < count && count <= 3000) {
            count = count + (int) (15 * (Math.random()));
        } else if (3000 < count && count <= 5000) {
            count = count + (int) (10 * (Math.random()));
        } else {
            count = count + 5;
        }
        zan.setCount(count);
        zanMapper.updateByPrimaryKey(zan);
        // 计算转发数
        long zfcount = (long) ((count / 5) * (0.8));
        Zan zf = zanMapper.selectByPrimaryKey(2);
        zf.setCount(zfcount);
        zanMapper.updateByPrimaryKey(zf);
    }

    @Override
    public Zan getZanCount() {
        return zanMapper.selectByPrimaryKey(1);
    }

    @Override
    public Zan getZfCount() {
        return zanMapper.selectByPrimaryKey(2);
    }

    @Override
    public synchronized Zan addDowmloadCount(Integer type) {
        if (type != null && type.equals(1)) {
            Zan zan = zanMapper.selectByPrimaryKey(3);
            zan.setCount(zan.getCount() + 1);
            zanMapper.updateByPrimaryKey(zan);
            return zan;
        } else {
            return zanMapper.selectByPrimaryKey(3);
        }
    }
}

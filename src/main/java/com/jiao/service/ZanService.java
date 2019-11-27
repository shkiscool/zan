package com.jiao.service;

import com.jiao.pojo.dao.Zan;

public interface ZanService {

    void addCount();

    Zan getZanCount();

    Zan getZfCount();

    Zan addDowmloadCount(Integer type);

}

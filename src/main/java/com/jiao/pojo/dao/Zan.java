package com.jiao.pojo.dao;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "zan")
public class Zan {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    private long id;

    /**
     * 统计数量
     */
    @Column(name = "count")
    private long count;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Zan() {
    }

    public Zan(long id, long count) {
        this.id = id;
        this.count = count;
    }
}

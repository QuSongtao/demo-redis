package com.suncd.redis.dao;

import com.suncd.redis.entity.PageDemoDto;

import java.util.List;
import java.util.Map;

/**
 * 描述：示例DAO接口
 *
 * @author QUST
 * @version 1.0
 * @date 2017/3/28
 */
public interface PageDemoDao {
    /**
     * 查询所有数据
     * @return
     */
    List<PageDemoDto> findAll();

    /**
     * 执行指定sql查询
     * @param sql
     * @return
     */
    List<Map<String, Object>> getQueryListBySql(String sql);

    /**
     * 按id查询
     * @param id
     * @return
     */
    PageDemoDto findById(String id);

    /**
     * 插入
     * @param pdd
     * @return
     */
    void insertData(PageDemoDto pdd);

    /**
     * 删除
     * @param pdd
     */
    void deleteById(PageDemoDto pdd);
}

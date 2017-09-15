package com.suncd.redis.service;

import com.suncd.redis.entity.PageDemoDto;

import java.util.List;

/**
 * Demo服务接口类
 *
 * @author qust
 * @version 1.0 2017-05-10
 */
public interface DemoService {
    PageDemoDto findById(String id);
    List<PageDemoDto> findAll();
    void deleteData(PageDemoDto pdd);
    PageDemoDto insertData(PageDemoDto pdd);
}
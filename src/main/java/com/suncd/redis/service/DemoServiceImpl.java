package com.suncd.redis.service;

import com.suncd.redis.dao.PageDemoDao;
import com.suncd.redis.entity.PageDemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务类（加入缓存管理）建议只对单对象进行缓存，集合对象避免使用缓存
 *
 * @author qust
 * @version 1.0 2017-05-10
 *
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private PageDemoDao pageDemoDao;

    /**
     * Cacheable 每次查询，将查询结果放入缓存中
     *           相同id，第二次查询时只从缓存中取数据，提高数据查询效率
     *           key = "#id" : 表示在redis中k-v(key:id,value:PageDemoDto)
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "pageCache",key = "#id")
    public PageDemoDto findById(String id) {
        System.out.println("从关系数据库中查询！");
        return pageDemoDao.findById(id);
    }

    /**
     * CacheEvict 删除的数据，要将缓存中的信息清除
     * @param pdd
     */
    @Override
    @Transactional
    @CacheEvict(value = "pageCache",key = "#pdd.id")
    public void deleteData(PageDemoDto pdd) {
        pageDemoDao.deleteById(pdd);
    }

    /**
     * CachePut 每次都触发真实的方法调用，将执行结果放入缓存中
     *          update 和 insert 实现方式一样
     * @param pdd
     * @return
     */
    @Override
    @CachePut(value = "pageCache",key = "#pdd.id")
    public PageDemoDto insertData(PageDemoDto pdd) {
        insert(pdd);
        //插入（或更新）关系数据库后，重新按id查询出来，放入缓存中
        return pageDemoDao.findById(pdd.getId());
    }

    /**
     * 事务管理（ insert or update ）
     * @param pdd
     */
    @Transactional
    public void insert(PageDemoDto pdd) {
        pageDemoDao.insertData(pdd);
    }


    /**
     * List<?> 对象不建议纳入缓存管理，
     *         数据精确度降低缓存刷新难度大
     *         key利用配置的生成器来生成
     * @return
     */
    @Override
    @Cacheable(value = "pageCache",keyGenerator = "wiselyKeyGenerator")
    public List<PageDemoDto> findAll() {
        return pageDemoDao.findAll();
    }
}
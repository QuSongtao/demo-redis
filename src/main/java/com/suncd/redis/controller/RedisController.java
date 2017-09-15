package com.suncd.redis.controller;

import com.suncd.redis.entity.PageDemoDto;
import com.suncd.redis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：redis demo控制器
 *
 * @author qust
 * @version 1.0  2017/5/10
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private DemoService demoService;

    /**
     * 按id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public PageDemoDto testRedis(@PathVariable("id") String id){
        return demoService.findById(id);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<PageDemoDto> getAll(){
        return demoService.findAll();
    }

    /**
     * 插入
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insert(){
        demoService.insertData(new PageDemoDto("15","15","15","15"));
        return "ok";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(){
        demoService.deleteData(new PageDemoDto("15","15","15","15"));
        return "ok";
    }

}

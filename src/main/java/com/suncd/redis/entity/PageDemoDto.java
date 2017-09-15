package com.suncd.redis.entity;

/**
 * 描述：测试实体
 *
 * @author QUST
 * @version 1.0
 * @date 2017/3/28
 */
public class PageDemoDto {
    /**
     * 主键
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 备注
     */
    private String demoColumn;

    public String getDemoColumn() {
        return demoColumn;
    }

    public void setDemoColumn(String demoColumn) {
        this.demoColumn = demoColumn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PageDemoDto(String id, String name, String description, String demoColumn) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.demoColumn = demoColumn;
    }

    public PageDemoDto() {
    }
}

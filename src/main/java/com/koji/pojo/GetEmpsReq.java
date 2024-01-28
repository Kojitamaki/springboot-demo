package com.koji.pojo;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * @author koji
 * @create 2024-01-20 15:06
 * 获取员工信息 封装请求参数实体类
 **/

public class GetEmpsReq {

    private String name;
    private Integer gender;
    private String begin;
    private String end;
    private Integer page;
    private Integer pageSize;
    private Integer pageStart;

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    @Override
    public String toString() {
        return "GetEmpsReq{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", begin=" + begin +
                ", end=" + end +
                ", page=" + page +
                ", getSize=" + pageSize +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

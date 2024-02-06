package com.koji.service;

import com.koji.pojo.Dept;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 1. @ClassName DeptService
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/17 23:53
 * 5. @Version 1.0
 */

public interface DeptService {
    List<Dept> list();

    void delete(Integer id, HttpServletRequest request);

    void add(Dept dept);

    Dept selectById(Integer id);

    void update(Dept dept);
}

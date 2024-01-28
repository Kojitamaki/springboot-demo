package com.koji.service.imp;

import com.koji.mapper.DeptMapper;
import com.koji.pojo.Dept;
import com.koji.pojo.Emp;
import com.koji.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 1. @ClassName DeptServiceImpl
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/17 23:53
 * 5. @Version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        List<Dept> list = deptMapper.list();
        return list;
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept selectById(Integer id) {
        Dept dept = deptMapper.selectById(id);
        return dept;
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

}

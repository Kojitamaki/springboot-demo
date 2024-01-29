package com.koji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.koji.mapper.EmpMapper;
import com.koji.pojo.Emp;
import com.koji.pojo.GetEmpsReq;
import com.koji.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. @ClassName EmpServiceImpl
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/17 23:54
 * 5. @Version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Map<String, Object> getEmps(Integer page, Integer pageSize, String name, String gender, LocalDate begin, LocalDate end) {
        /*--  使用分页插件PageHelper简化分页查询 -- */
        // 1.设置分页参数
        // PageHepler框架实现分页最核心的代码就是在运行要分页的查询语句之前
        // 通过框架给定的方法设置要分页查询的要求(第几页(从1开始),每页多少条)
        PageHelper.startPage(page, pageSize);
        // 2.执行查询
        // 当上面设置完分页要求后,下面紧随的下一次查询,
        // 就会自动在sql语句末尾添加limit关键字,limit后面的值就是按page,pageSize得出的
        // 此时empList查询出来的数据不是全部的数据，而是分页过后的分页数据
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        // 使用PageHelper框架提供的PageInfo类型对象对查询结果进行封装，能自动计算分页信息
        PageInfo<Emp> p = new PageInfo<>(empList);
        // 3.封装结果，这里使用Map返回结果，也可以定义实体类返回
        Map<String, Object> result = new HashMap<>();
        // 获取总条数
        result.put("total", p.getTotal());
        // 获取查询集合
        result.put("rows", p.getList());
        return result;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}

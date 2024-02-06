package com.koji.service.imp;

import com.koji.mapper.DeptMapper;
import com.koji.mapper.EmpMapper;
import com.koji.pojo.Dept;
import com.koji.pojo.DeptLog;
import com.koji.pojo.Emp;
import com.koji.service.DeptLogService;
import com.koji.service.DeptService;
import com.koji.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        List<Dept> list = deptMapper.list();
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)  // 开启spring事务管理，同时回滚策略为：任何异常都回滚
    public void delete(Integer id, HttpServletRequest httpServletRequest) {
        try {
            deptMapper.delete(id);
            int i = 1/0;
            empMapper.deleteById(id);  // 删除部门下的所有员工
        } finally {
            String token = httpServletRequest.getHeader("token");
            Claims claims = JwtUtils.parseJWT(token);
            DeptLog deptLog = DeptLog.builder()
                    .createTime(LocalDateTime.now())
                    .description("执行了解散部门操作，此次解散的是" + id + "号部门, 操作来自于:" + claims.get("name"))
                    .build();
            deptLogService.insertLog(deptLog);
        }
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

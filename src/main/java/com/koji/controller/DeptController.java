package com.koji.controller;

import com.koji.pojo.Dept;
import com.koji.pojo.Emp;
import com.koji.pojo.Result;
import com.koji.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.PostgresCallMetaDataProvider;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 1. @ClassName DeptController
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/17 23:51
 * 5. @Version 1.0
 */
@RestController
@RequestMapping("/depts")
public class DeptController {

    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /*
    *查询部门数据
    * */
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> list = deptService.list();
        return Result.success(list);
    }

    /*
    *删除部门
    * */

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id, HttpServletRequest request){
        log.info("根据id删除部门：{}",id);
        deptService.delete(id, request);
        return Result.success();
    }

    /*
    * 添加部门
    * */
    @PostMapping
    public Result add(@RequestBody Dept dept){

        log.info("新增部门数据:{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /*
    * 根据id查询部门
    * */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id查询部门:{}",id);
        Dept dept = deptService.selectById(id);
        return Result.success(dept);
    }

    /*
    *
    * */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
}

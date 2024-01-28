package com.koji.controller;

import com.koji.pojo.Emp;
import com.koji.pojo.GetEmpsReq;
import com.koji.pojo.Result;
import com.koji.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 1. @ClassName EmpController
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/17 23:51
 * 5. @Version 1.0
 */
@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result getEmps(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          String name, String gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                          @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        Map<String, Object> map = empService.getEmps(page,pageSize,name, gender, begin, end);
        return Result.success(map);
    }

    @DeleteMapping("/{ids}")
    Result delete(@PathVariable List<Integer> ids){
        log.info("执行批量删除, ids:{}", ids);
        empService.delete(ids);
        return Result.success();
    }


    @PostMapping
    Result save(@RequestBody Emp emp){
        log.info("新增员工,emp:{}", emp);
        empService.save(emp);
        return Result.success();
    }
}

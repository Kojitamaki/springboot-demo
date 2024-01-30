package com.koji.service;

import com.koji.mapper.EmpMapper;
import com.koji.pojo.Emp;
import com.koji.pojo.GetEmpsReq;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 1. @ClassName EmpService
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/17 23:53
 * 5. @Version 1.0
 */
@Service
public interface EmpService {
    Map<String, Object> getEmps(Integer page,Integer pageSize, String name, String gender, LocalDate begin,LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}

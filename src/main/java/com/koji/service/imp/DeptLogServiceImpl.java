package com.koji.service.imp;

import com.koji.mapper.DeptLogMapper;
import com.koji.pojo.DeptLog;
import com.koji.pojo.Result;
import com.koji.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 1. @ClassName DeptLogServiceImpl
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/2/6 23:42
 * 5. @Version 1.0
 */
@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Result insertLog(DeptLog deptLog) {
        deptLogMapper.insertLog(deptLog);
        return Result.success();
    }
}

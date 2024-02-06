package com.koji.service;

import com.koji.pojo.DeptLog;
import com.koji.pojo.Result;
import org.springframework.stereotype.Service;

/**
 * 1. @ClassName DeptLogService
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/2/6 23:41
 * 5. @Version 1.0
 */

public interface DeptLogService {
    Result insertLog(DeptLog deptLog);
}

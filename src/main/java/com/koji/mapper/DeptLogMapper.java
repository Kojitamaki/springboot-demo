package com.koji.mapper;

import com.koji.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 1. @ClassName DeptLogMapper
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/2/6 23:46
 * 5. @Version 1.0
 */
@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log(create_time, description) values (#{createTime},#{description})")
    void insertLog(DeptLog deptLog);
}

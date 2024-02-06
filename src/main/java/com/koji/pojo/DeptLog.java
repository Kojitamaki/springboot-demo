package com.koji.pojo;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 1. @ClassName DeptLog
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/2/6 23:43
 * 5. @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptLog {
    private Integer id;
    private LocalDateTime createTime;
    private String description;
}

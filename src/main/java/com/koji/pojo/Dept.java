package com.koji.pojo;

/**
 * 1. @ClassName Dept
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/17 23:55
 * 5. @Version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 部门实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id; //ID
    private String name; //部门名称
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}


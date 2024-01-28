package com.koji.mapper;

import com.koji.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 1. @ClassName DeptMapper
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/17 23:52
 * 5. @Version 1.0
 */
@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    void add(Dept dept);


    @Select("Select * from dept where id = #{id}" )
    Dept selectById(Integer id);

    @Update("update dept set name = #{name}, update_time =#{updateTime} where id=#{id}")
    void update(Dept dept);
}

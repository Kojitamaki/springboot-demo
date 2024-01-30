package com.koji.mapper;

import com.koji.pojo.Emp;
import com.koji.pojo.GetEmpsReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

/**
 * 1. @ClassName EmpMapper
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/17 23:52
 * 5. @Version 1.0
 */
@Mapper
public interface EmpMapper {


//    // 获取分页员工信息
//    List<Emp> getEmps(@Param("a") GetEmpsReq getEmpsReq,@Param("pageStart") Integer pageStart);
//    // 获取员工总记录数
//    Integer count(@Param("a") GetEmpsReq getEmpsReq);


    /*
    * 员工信息查询
    * PageHelper框架是自动在sql语句后添加limit关键字实现分页的
    * 因为这个特性,我们编写的查询语句,和不分页时是一样的
    * */
//    @Select("select * from emp")
    List<Emp> list(@Param(value = "name") String name, @Param(value = "gender") String gender, @Param(value = "begin") LocalDate begin, @Param(value = "end") LocalDate end);

    void delete(List<Integer> ids);

    void insert(Emp emp);


    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password} ")
    Emp getByUsernameAndPassword(Emp emp);
}

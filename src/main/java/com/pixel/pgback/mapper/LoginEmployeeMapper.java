package com.pixel.pgback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pixel.pgback.entity.LoginEmployee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface LoginEmployeeMapper extends BaseMapper<LoginEmployee> {
    /**
     * mbg生成的插入，插入不为空的信息
     *
     * @param record
     * @return
     */
    int insertSelective(LoginEmployee record);

    /**
     * 查询员工id为employeeId的记录数，用于注册控制
     *
     * @param employeeId
     * @return
     */
    int selectCountByEmployeeId(Integer employeeId);

    /**
     * 登录校验
     *
     * @param username
     * @param password
     * @return login_employee.id employee.identity
     */
    Map selectLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询员工id
     *
     * @param username
     * @return
     */
    Integer selectEmployeeIdByUsername(String username);
}
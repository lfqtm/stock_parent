package com.jrzs.stock.mapper;

import com.jrzs.stock.pojo.SysUserRole;

/**
 * @Entity com.jrzs.stock.pojo.SysUserRole
 */
public interface SysUserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

}

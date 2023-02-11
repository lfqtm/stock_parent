package com.jrzs.stock.mapper;

import com.jrzs.stock.pojo.SysRole;

/**
 * @Entity com.jrzs.stock.pojo.SysRole
 */
public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

}

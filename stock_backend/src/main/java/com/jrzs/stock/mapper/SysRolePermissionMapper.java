package com.jrzs.stock.mapper;

import com.jrzs.stock.pojo.SysRolePermission;

/**
 * @Entity com.jrzs.stock.pojo.SysRolePermission
 */
public interface SysRolePermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);

}

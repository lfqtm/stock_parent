package com.jrzs.stock.mapper;

import com.jrzs.stock.pojo.SysPermission;

/**
 * @Entity com.jrzs.stock.pojo.SysPermission
 */
public interface SysPermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

}

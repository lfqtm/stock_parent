package com.jrzs.stock.mapper;

import com.jrzs.stock.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity com.jrzs.stock.pojo.SysUser
 */
public interface SysUserMapper {

	SysUser findById(@Param("id") String id);

	SysUser findByUserName(@Param("username") String username);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

}

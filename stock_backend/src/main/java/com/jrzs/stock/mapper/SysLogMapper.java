package com.jrzs.stock.mapper;

import com.jrzs.stock.pojo.SysLog;

/**
 * @Entity com.jrzs.stock.pojo.SysLog
 */
public interface SysLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

}

package com.jrzs.stock.mapper;

import com.jrzs.stock.pojo.StockBlockRtInfo;

import java.util.List;

/**
 * @Entity com.jrzs.stock.pojo.StockBlockRtInfo
 */
public interface StockBlockRtInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockBlockRtInfo record);

    int insertSelective(StockBlockRtInfo record);

    StockBlockRtInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockBlockRtInfo record);

    int updateByPrimaryKey(StockBlockRtInfo record);

	List<StockBlockRtInfo> sectorAllLimit();
}

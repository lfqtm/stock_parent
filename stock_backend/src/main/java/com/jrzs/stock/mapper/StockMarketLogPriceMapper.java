package com.jrzs.stock.mapper;

import com.jrzs.stock.pojo.StockMarketLogPrice;

/**
 * @Entity com.jrzs.stock.pojo.StockMarketLogPrice
 */
public interface StockMarketLogPriceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockMarketLogPrice record);

    int insertSelective(StockMarketLogPrice record);

    StockMarketLogPrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockMarketLogPrice record);

    int updateByPrimaryKey(StockMarketLogPrice record);

}

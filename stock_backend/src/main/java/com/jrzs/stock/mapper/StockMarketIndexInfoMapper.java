package com.jrzs.stock.mapper;

import com.jrzs.stock.common.domain.InnerMarketDomain;
import com.jrzs.stock.pojo.StockMarketIndexInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Entity com.jrzs.stock.pojo.StockMarketIndexInfo
 */
public interface StockMarketIndexInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockMarketIndexInfo record);

    int insertSelective(StockMarketIndexInfo record);

    StockMarketIndexInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockMarketIndexInfo record);

    int updateByPrimaryKey(StockMarketIndexInfo record);

	List<InnerMarketDomain> selectByIdsAndDate(@Param("ids") List<String> ids, @Param("lastDate") Date lastDate);
}

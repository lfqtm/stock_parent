package com.jrzs.stock.service;

import com.jrzs.stock.common.domain.InnerMarketDomain;
import com.jrzs.stock.pojo.StockBlockRtInfo;
import com.jrzs.stock.pojo.StockBusiness;
import com.jrzs.stock.vo.R;

import java.util.List;

public interface StockService {
	List<StockBusiness> findAll();

	R<List<StockBlockRtInfo>> sectorAllLimit();

	R<List<InnerMarketDomain>> innerIndexAll();
}

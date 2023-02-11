package com.jrzs.stock.service.impl;

import com.jrzs.stock.common.domain.InnerMarketDomain;
import com.jrzs.stock.common.domain.StockInfoConfig;
import com.jrzs.stock.mapper.StockBlockRtInfoMapper;
import com.jrzs.stock.mapper.StockBusinessMapper;
import com.jrzs.stock.mapper.StockMarketIndexInfoMapper;
import com.jrzs.stock.pojo.StockBlockRtInfo;
import com.jrzs.stock.pojo.StockBusiness;
import com.jrzs.stock.service.StockService;
import com.jrzs.stock.utils.DateTimeUtil;
import com.jrzs.stock.vo.R;
import com.jrzs.stock.vo.ResponseCode;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("stockService")
public class StockServiceImpl implements StockService {

	@Resource
	private StockBusinessMapper stockBusinessMapper;

	@Resource
	private StockBlockRtInfoMapper stockBlockRtInfoMapper;

	@Resource
	private StockInfoConfig stockInfoConfig;

	@Resource
	private StockMarketIndexInfoMapper stockMarketIndexInfoMapper;

	@Override
	public List<StockBusiness> findAll() {
		return stockBusinessMapper.findBusiness();
	}

	@Override
	public R<List<StockBlockRtInfo>> sectorAllLimit() {
		//1.调用mapper接口获取数据 TODO 优化 避免全表查询 根据时间范围查询，提高查询效率
		List<StockBlockRtInfo> infos= stockBlockRtInfoMapper.sectorAllLimit();
		//2.组装数据
		if (CollectionUtils.isEmpty(infos)) {
			return R.error(ResponseCode.NO_RESPONSE_DATA.getMessage());
		}
		return R.ok(infos);
	}

	@Override
	public R<List<InnerMarketDomain>> innerIndexAll() {
		//1.获取国内大盘的id集合
		List<String> innerIds = stockInfoConfig.getInner();
		//2.获取最近最新的股票有效交易日
		Date lDate = DateTimeUtil.getLastDate4Stock(DateTime.now()).toDate();
		//mock数据
		String mockDate="20211226105600";//TODO后续大盘数据实时拉去，将该行注释掉 传入的日期秒必须为0
		lDate = DateTime.parse(mockDate, DateTimeFormat.forPattern("yyyyMMddHHmmss")).toDate();
		//3.调用mapper查询指定日期下对应的国内大盘数据
		List<InnerMarketDomain> maps= stockMarketIndexInfoMapper.selectByIdsAndDate(innerIds,lDate);
		//组装响应的额数据
		if (CollectionUtils.isEmpty(maps)) {
			return R.error(ResponseCode.NO_RESPONSE_DATA.getMessage());
		}
		return R.ok(maps);
	}
}

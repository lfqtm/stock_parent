package com.jrzs.stock.controller;

import com.jrzs.stock.common.domain.InnerMarketDomain;
import com.jrzs.stock.pojo.StockBlockRtInfo;
import com.jrzs.stock.pojo.StockBusiness;
import com.jrzs.stock.service.StockService;
import com.jrzs.stock.vo.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/quot")
@CrossOrigin
public class StockController {

	@Resource
	private StockService stockService;

	@GetMapping("/index/all")
	public R<List<InnerMarketDomain>> innerIndexAll(){
		return stockService.innerIndexAll();
	}

	@GetMapping("/sector/all")
	public R<List<StockBlockRtInfo>> sectorAll() {
		return stockService.sectorAllLimit();
	}

	@GetMapping("/stock/business/all")
	public List<StockBusiness> findAllBusinessInfo() {
		return stockService.findAll();
	}

}

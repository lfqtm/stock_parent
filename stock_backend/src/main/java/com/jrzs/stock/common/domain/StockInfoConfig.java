package com.jrzs.stock.common.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "stock")
public class StockInfoConfig {
	//a股大盘ID集合
	private List<String> inner;
	//外盘ID集合
	private List<String> outer;
}

package com.jrzs.stock;

import com.jrzs.stock.common.domain.StockInfoConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@ConfigurationPropertiesScan
@EnableConfigurationProperties(StockInfoConfig.class)
@MapperScan("com.jrzs.stock.mapper")
public class StockApp {
	public static void main(String[] args) {
		SpringApplication.run(StockApp.class, args);
	}
}

package com.jrzs.stock.config;

import com.jrzs.stock.utils.CaptchaImage;
import com.jrzs.stock.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CommonConfig {
	/**
	 * 密码加密器
	 * BCryptPasswordEncoder方法采用SHA-256对密码进行加密
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	/**
	 * 分布式id生成器
	 * @return
	 */
	@Bean
	public IdWorker idWorker() {
		return new IdWorker(2L, 1L);
	}

	/**
	 * 验证码图片
	 * @return
	 */
	@Bean
	public CaptchaImage buildCaptchaImage() {
		return new CaptchaImage();
	}
}

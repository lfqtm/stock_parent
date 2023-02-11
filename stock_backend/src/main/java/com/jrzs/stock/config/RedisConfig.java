package com.jrzs.stock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory rcf) {
		RedisTemplate<Object, Object> te = new RedisTemplate<>();
		te.setConnectionFactory(rcf);
		// key的序列化
		te.setKeySerializer(new StringRedisSerializer());
		te.setHashKeySerializer(new StringRedisSerializer());
		return te;
	}
}
